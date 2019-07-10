package fr.mb.volontario.business.impl;

import fr.mb.volontario.business.contract.InscriptionManager;
import fr.mb.volontario.dao.contract.*;
import fr.mb.volontario.model.bean.*;
import fr.mb.volontario.model.dto.BenevoleDTO;
import fr.mb.volontario.model.dto.InscriptAssoDTO;
import fr.mb.volontario.model.dto.InscriptBeneDTO;
import fr.mb.volontario.model.dto.InscriptionDTO;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public Association inscriptionAsso(InscriptAssoDTO association) throws FunctionalException {
        if (associationDAO.existsBySiret(association.getAssociation().getSiret()))
            throw new FunctionalException("L'association est déjà enregistrée");

        else if (userDao.existsByIdentifiant(association.getIdentifiant()))
            throw new FunctionalException("L'identifiant est déjà utilisé");
        else if (association.getAssociation().getPhoto() == null) association.getAssociation().setPhoto("photodef.jpg");
        Association asso = new Association();
        asso = association.getAssociation();
        User user = new User();
        user.setIdentifiant(association.getIdentifiant());
        user.setMdp(bcryptEncoder.encode(association.getMdp()));
        user.setRole(association.getRole());
        user.setMail(association.getMail());
        user.setAssociation(asso);
        asso.getUsers().add(user);
        return  associationDAO.save(asso);
    }

    @Override
    @Transactional
    public Benevole inscriptionBene(InscriptBeneDTO benevole) throws FunctionalException {
        Benevole bene;
        if (userDao.existsByIdentifiant(benevole.getIdentifiant()))
            throw new FunctionalException("L'identifiant est déjà utilisé");
        else {
            bene = benevole.getBenevole();
            User user = new User();
            user.setIdentifiant(benevole.getIdentifiant());
            user.setMdp(bcryptEncoder.encode(benevole.getMdp()));
            user.setRole(benevole.getRole());
            user.setMail(benevole.getMail());
            user.setBenevole(bene);
            bene.setUser(user);
            return benevoleDAO.save(bene);
        }
    }

    @Override
    @Transactional
    public Inscription saveInscription(Inscription inscription, Integer idMission) throws FunctionalException {
        Assert.notNull(inscription, "L'inscription est obligatoire");
        Assert.notNull(idMission, "L'id de la mission est obligatoire");
        Mission mission = missionDao.findById(idMission).orElse(null);
        if (mission == null) throw new FunctionalException("La mission n'existe pas");
        else {
            inscription.setMission(mission);
            return inscriptionDao.save(inscription);
        }
    }

    @Override
    @Transactional
    public void deleteInscription(Integer idInscription) throws NotFoundException {
        Assert.notNull(idInscription, "L'id de l'inscription est obligatoire");
        Inscription inscription = inscriptionDao.findById(idInscription).orElse(null);
        if (inscription == null) throw new NotFoundException("L'inscription n'existe pas");
        else {
            inscriptionDao.delete(inscription);
        }

    }

    @Override
    @Transactional
    public void deleteListeInscription(List<Integer> idsInscription) {
        Assert.notNull(idsInscription, "La liste est obligatoire");
        for (Integer id : idsInscription) {
            inscriptionDao.deleteById(id);
        }
    }

    @Override
    public List<InscriptionDTO> getInsctriptionByMission(Integer idMission) {
        Assert.notNull(idMission, "L'id de la mission est obligatoire");
        List<InscriptionDTO> inscriptionDTOS = new ArrayList<>();
        List<Inscription> inscriptions = inscriptionDao.findAllByMissionIdMission(idMission);
        for (Inscription inscription : inscriptions) {
            InscriptionDTO inscriptionDTO = new InscriptionDTO();
            inscriptionDTO.setInscription(inscription);
            List<BenevoleDTO> benevoleDTOS = new ArrayList<>();
            if (!inscription.getBenevoles().isEmpty()) {
                for (Benevole benevole : inscription.getBenevoles()) {
                    BenevoleDTO benevoleDTO = new BenevoleDTO();
                    benevoleDTO.setBenevole(benevole);
                    benevoleDTO.setIdentifiant(benevole.getUser().getIdentifiant());
                    benevoleDTO.setMail(benevole.getUser().getMail());
                    benevoleDTOS.add(benevoleDTO);
                }
            }
            inscriptionDTO.setBenevole(benevoleDTOS);
            if (inscriptionDTO.getBenevole() != null)
                inscriptionDTO.setNbInscription(inscriptionDTO.getBenevole().size());
            else inscriptionDTO.setNbInscription(0);
            inscriptionDTOS.add(inscriptionDTO);
        }
        return inscriptionDTOS;
    }

    @Override
    public List<Benevole> getBenevoleByIdInscription(Integer idInscription) throws NotFoundException {
        Assert.notNull(idInscription, "L'id de l'inscription est obligatoire");
        Inscription inscription = inscriptionDao.findById(idInscription).orElse(null);
        if (inscription == null) throw new NotFoundException("Inscription non trouvée");
        else {
            List<Benevole> benevoles = new ArrayList<>(inscription.getBenevoles());
            return benevoles;
        }
    }
}
