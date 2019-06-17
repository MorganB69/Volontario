package fr.mb.volontario.business.impl;

import fr.mb.volontario.business.contract.InscriptionManager;
import fr.mb.volontario.dao.contract.*;
import fr.mb.volontario.model.bean.Association;
import fr.mb.volontario.model.bean.Benevole;
import fr.mb.volontario.model.bean.Inscription;
import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InscriptionManagerImpl implements InscriptionManager {

    @Autowired
    AssociationDAO associationDAO;

    @Autowired
    UserDao userDao;

    @Autowired
    BenevoleDAO benevoleDAO;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;
    @Autowired
    private MissionDAO missionDao;
    @Autowired
    private InscriptionDAO inscriptionDao;

    /**
     * @param association
     * @return
     * @throws FunctionalException
     */
    @Override
    @Transactional
    public Association inscriptionAsso(Association association) throws FunctionalException {
        if (associationDAO.existsBySiret(association.getSiret())) throw new FunctionalException("L'association est déjà enregistrée");

        else if (userDao.existsByIdentifiant( association.getUsers().iterator().next().getIdentifiant())) throw new FunctionalException("L'identifiant est déjà utilisé");
        else
        if(association.getPhoto()==null)association.setPhoto("photodef.jpg");
        association.getUsers().iterator().next().setMdp((bcryptEncoder.encode(association.getUsers().iterator().next().getMdp())));
        associationDAO.save(association);

        return association;
    }

    @Override
    @Transactional
    public Benevole inscriptionBene(Benevole benevole) throws FunctionalException {
        if (userDao.existsByIdentifiant(benevole.getUser().getIdentifiant())) throw new FunctionalException("L'identifiant est déjà utilisé");
        else {
            benevole.getUser().setMdp((bcryptEncoder.encode(benevole.getUser().getMdp())));
            benevoleDAO.save(benevole);
        }
        return benevole;
    }

    @Override
    @Transactional
    public Inscription saveInscription(Inscription inscription, Integer idMission) throws FunctionalException {
        Assert.notNull(inscription, "L'inscription est obligatoire");
        Assert.notNull(idMission, "L'id de la mission est obligatoire");
        Mission mission = missionDao.findById(idMission).orElse(null);
        if (mission==null) throw new FunctionalException("La mission n'existe pas");
        else {
            inscription.setMission(mission);
            return inscriptionDao.save(inscription);
        }
    }

    @Override
    @Transactional
    public void deleteInscription(Integer idInscription) throws NotFoundException {
        Assert.notNull(idInscription, "L'id de l'inscription est obligatoire");
        Inscription inscription= inscriptionDao.findById(idInscription).orElse(null);
        if (inscription==null) throw new NotFoundException("L'inscription n'existe pas");
        else {
            inscriptionDao.delete(inscription);
        }

    }

    @Override
    @Transactional
    public void deleteListeInscription(List<Integer> idsInscription) {
        Assert.notNull(idsInscription, "La liste est obligatoire");
        for (Integer id: idsInscription){
            inscriptionDao.deleteById(id);
        }
    }
}
