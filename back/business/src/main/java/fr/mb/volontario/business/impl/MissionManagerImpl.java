package fr.mb.volontario.business.impl;

import com.google.common.collect.Lists;
import fr.mb.volontario.business.contract.EmailService;
import fr.mb.volontario.business.contract.MissionManager;
import fr.mb.volontario.dao.contract.*;
import fr.mb.volontario.dao.impl.MissionDAOImpl;
import fr.mb.volontario.model.Mail;
import fr.mb.volontario.model.bean.*;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import fr.mb.volontario.model.recherche.RechercheAdresse;
import fr.mb.volontario.model.recherche.RechercheMission;
import freemarker.template.TemplateException;
import org.aspectj.weaver.ast.Not;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MissionManagerImpl implements MissionManager {

    @Autowired
    MissionDAO missionDAO;

    @Autowired
    DomaineDAO domaineDAO;

    @Autowired
    AdresseDAO adresseDAO;

    @Autowired
    AssociationDAO associationDAO;

    @Autowired
    UserDao userDao;

    @Autowired
    InscriptionDAO inscriptionDAO;

    @Autowired
    EmailService emailService;

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



//-----------Mail------------------
    @Override
    @Transactional
    public void mailConsigne(Integer inscriptionId, String username) throws MessagingException, IOException, TemplateException, FunctionalException, NotFoundException {

        Map<String, Object> model = this.mailDonnees(inscriptionId,username);
        Mail mail = new Mail("mb.testocrbiblio@gmail.com", (String) model.get("mailbene"), "Inscription mission Volontario");


        mail.setModel(model);
        emailService.sendSimpleMessage(mail,"consigne.ftl");
    }

    @Override
    @Transactional
    public void mailInscriAsso(Integer inscriptionId, String username) throws MessagingException, IOException, TemplateException, FunctionalException, NotFoundException {

        Map<String, Object> model = this.mailDonnees(inscriptionId,username);
        Mail mail = new Mail("mb.testocrbiblio@gmail.com", (String) model.get("mailasso"), "Un bénévole s'est inscrit à votre mission");


        mail.setModel(model);
        emailService.sendSimpleMessage(mail,"inscription.ftl");
    }

    @Override
    @Transactional
    public void mailDesinscriAsso(Integer inscriptionId, String username) throws NotFoundException, MessagingException, IOException, TemplateException {

        Map<String, Object> model = this.mailDonnees(inscriptionId,username);
        Mail mail = new Mail("mb.testocrbiblio@gmail.com", (String) model.get("mailasso"), "Un bénévole s'est désinscrit de votre mission");




        mail.setModel(model);
        emailService.sendSimpleMessage(mail,"desinscription.ftl");

    }

    @Override
    @Transactional
    public Mission saveMission(Mission mission, Integer idAssociation) throws NotFoundException {
        Assert.notNull(mission, "l'id de l'association est obligatoire");
        Assert.notNull(mission, "La mission est obligatoire");
        Association association = associationDAO.findById(idAssociation).orElse(null);
        if (association == null) throw new NotFoundException("L'association n'existe pas");
        else {
            mission.setAssociation(association);
            return missionDAO.save(mission);
        }
    }



    @Override
    @Transactional
    public List<Mission> getMissionsByIdAsso(Integer idAssociation) throws NotFoundException, FunctionalException{
        Assert.notNull(idAssociation, "L'id de l'association est obligatoire");
        Association association = associationDAO.findById(idAssociation).orElse(null);
        if(association==null) throw new NotFoundException("L'association n'existe pas");
        else {
            List<Mission> missions = missionDAO.findAllByAssociation(association);
            return missions;
        }
    }

    @Override
    @Transactional
    public void deleteMission(Integer idMission) throws NotFoundException {
        Assert.notNull(idMission, "l'id de la mission est obligatoire");
        Mission mission = missionDAO.findById(idMission).orElse(null);
        if (mission==null) throw new NotFoundException("La mission n'existe pas");
        else {
            missionDAO.delete(mission);
        }

    }


    private Map<String, Object> mailDonnees(Integer inscriptionId, String username) throws NotFoundException {
        User user = userDao.findByIdentifiant(username);
        Inscription inscription = inscriptionDAO.findById(inscriptionId).orElseThrow(() ->  new NotFoundException("inscription non trouvée"));

        Map<String, Object> model = new HashMap<>();
        Association asso = inscription.getMission().getAssociation();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy : kk:mm");
        LocalDateTime debut = inscription.getDebut().toLocalDateTime();
        String debutString = debut.format(formatter);
        LocalDateTime fin = inscription.getFin().toLocalDateTime();
        String finString = fin.format(formatter);


        String adresse =
                inscription.getMission().getAdresse().getVoie() +' '+
                        inscription.getMission().getAdresse().getCommune() +' '+
                        inscription.getMission().getAdresse().getCode();


        String mailbene = user.getMail();
        String mailasso = asso.getUsers().iterator().next().getMail();

        model.put("nomAsso", asso.getNom());
        model.put("identifiant", user.getIdentifiant());
        model.put("adresse", adresse);
        model.put("debut", debutString);
        model.put("fin",finString);
        model.put("inscription",inscription);
        model.put("mission",inscription.getMission());
        model.put("mailbene",mailbene);
        model.put("mailasso",mailasso);

        return model;
    }

    //-----------------------------Methodes de contrôles------------------------------

    //CheckInscription
    private void checkInscription(Integer idInscription) throws FunctionalException {
        if(idInscription==null || idInscription<=0) throw new FunctionalException("erreur de donnée l'id est incorrect");
    }

    //CheckUser
    private void checkUser(User user) throws NotFoundException{
        if (user==null) throw new NotFoundException("utilisateur non trouvé");
    }
    //Verif du nombre de place restantes
    private void checkNbPlace(Inscription inscription) throws FunctionalException{
        if (inscription.getNbplaces()<=0) throw new FunctionalException("il n'y a plus de place disponible");
    }
    //Verif que l'utilisateur n'est pas inscrit
    private void checkUserInscription(Inscription inscription, User user) throws  FunctionalException{
        for (Benevole benevole:inscription.getBenevoles()
        ) {
            if (benevole.getUser().getIdentifiant().equals(user.getIdentifiant())) throw new FunctionalException("L'utilisateur est déjà inscrit à cette mission");
        }
    }


}
