package fr.mb.volontario.business.impl;

import fr.mb.volontario.business.contract.MissionManager;
import fr.mb.volontario.dao.contract.*;
import fr.mb.volontario.dao.impl.MissionDAOImpl;
import fr.mb.volontario.model.bean.*;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import fr.mb.volontario.model.recherche.RechercheAdresse;
import fr.mb.volontario.model.recherche.RechercheMission;
import org.aspectj.weaver.ast.Not;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MissionManagerImpl implements MissionManager {

    @Autowired
    MissionDAO missionDAO;

    @Autowired
    DomaineDAO domaineDAO;

    @Autowired
    AdresseDAO adresseDAO;

    @Autowired
    UserDao userDao;

    @Autowired
    InscriptionDAO inscriptionDAO;

    Logger logger = LoggerFactory.getLogger(MissionManagerImpl.class);

    @Override
    @Transactional
    public List<Mission> rechercheMission(RechercheMission recherche) throws FunctionalException {
        List<Mission> listReturn = null;
        try {
            listReturn = missionDAO.rechercheMission(recherche);
        }
        catch (Exception exception) {
            throw new FunctionalException("Une erreur est parvenue dans la recherche");
        }
        for (Mission mission:listReturn
             ) {
            logger.info(mission.getAssociation().getNom());
        }
        return listReturn;
    }

    @Override
    @Transactional
    public List<Domaine> findAllDomaine() throws NotFoundException {

        List<Domaine>listReturn = (List<Domaine>) domaineDAO.findAll();
        if (listReturn==null) throw new NotFoundException("Aucun domaine trouvé");

        return listReturn;
    }

    @Override
    @Transactional
    public List<String> findDepartement() throws NotFoundException {
        List<String> listReturn = adresseDAO.getDepartement();
        if (listReturn==null) throw new NotFoundException("Pas d'adresse trouvée");
        return listReturn;
    }

    @Override
    @Transactional
    public List<String> findCommune(String departement) throws NotFoundException {
        List<String> listReturn = adresseDAO.getCommunes(departement);
        if (listReturn==null) throw new NotFoundException("Pas d'adresse trouvée");
        return listReturn;
    }

    @Override
    public Mission getMissionById(Integer id) throws NotFoundException, FunctionalException {
        if(id==null || id <=0 ) throw new FunctionalException("erreur de donnée, l'id est incorrect");
        Mission mission = missionDAO.findById(id).orElseThrow(() -> new NotFoundException("Mission non trouvée"));
        return mission;
    }

    @Override
    @Transactional
    public void addUserToMission(String username, Integer inscriptionId) throws FunctionalException, NotFoundException{
        checkInscription(inscriptionId);
        User user;
        user = userDao.findByIdentifiant(username);
        checkUser(user);
        Inscription inscription = inscriptionDAO.findById(inscriptionId).orElseThrow(() ->  new NotFoundException("inscription non trouvée"));
        //Verif du nombre de place restante
        checkNbPlace(inscription);
        //Verif que l'utilisateur n'est pas déjà inscrit
        checkUserInscription(inscription,user);

        inscription.getBenevoles().add(user.getBenevole());
        inscription.setNbplaces(inscription.getNbplaces()-1);
        inscriptionDAO.save(inscription);
    }
    @Override
    @Transactional
    public void deleteUserFromMission(String username, Integer idInscription) throws FunctionalException, NotFoundException{
        checkInscription(idInscription);
        User user = userDao.findByIdentifiant(username);
        checkUser(user);

        Inscription inscription = inscriptionDAO.findById(idInscription).orElseThrow(() ->  new NotFoundException("inscription non trouvée"));

        for (Benevole bene:inscription.getBenevoles()
             ) {
            if(bene.getUser().getIdentifiant().equals(username)) {
                inscription.getBenevoles().remove(bene);
                inscription.setNbplaces(inscription.getNbplaces()+1);
                inscriptionDAO.save(inscription);
            }
        }
    }




    //-----------------------------Methodes de contrôles------------------------------
    //CheckInscription
    void checkInscription(Integer idInscription) throws FunctionalException {
        if(idInscription==null || idInscription<=0) throw new FunctionalException("erreur de donnée l'id est incorrect");
    }

    //CheckUser
    public void checkUser(User user) throws NotFoundException{
        if (user==null) throw new NotFoundException("utilisateur non trouvé");
    }
    //Verif du nombre de place restantes
    void checkNbPlace(Inscription inscription) throws FunctionalException{
        if (inscription.getNbplaces()<=0) throw new FunctionalException("il n'y a plus de place disponible");
    }
    //Verif que l'utilisateur n'est pas inscrit
    void checkUserInscription(Inscription inscription, User user) throws  FunctionalException{
        for (Benevole benevole:inscription.getBenevoles()
             ) {
           if (benevole.getUser().getIdentifiant().equals(user.getIdentifiant())) throw new FunctionalException("L'utilisateur est déjà inscrit à cette mission");
        }
    }


}
