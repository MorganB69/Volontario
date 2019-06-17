package fr.mb.volontario.service.impl;

import fr.mb.volontario.business.contract.InscriptionManager;
import fr.mb.volontario.business.contract.MissionManager;
import fr.mb.volontario.business.contract.UserManager;
import fr.mb.volontario.model.bean.*;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;

import fr.mb.volontario.model.recherche.RechercheMission;

import fr.mb.volontario.service.contract.webServiceRest;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.method.P;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(origins =  "*")
public class webServiceRestImpl implements webServiceRest {

    Logger logger = LoggerFactory.getLogger(webServiceRestImpl.class);

    @Autowired
    MissionManager missionManager;
    @Autowired
    InscriptionManager inscriptionManager;
    @Autowired
    UserManager userManager;


    @Override
    @PostMapping(value="/mission/recherche")
    public List<Mission> rechercheMission(@RequestBody RechercheMission recherche) throws FunctionalException {
        List<Mission> listMission = missionManager.rechercheMission(recherche);
        return listMission;
    }

    @Override
    @GetMapping(value = "/mission/domaines")
    public List<Domaine> findAllDomaine() throws NotFoundException {
        List<Domaine> listDomaine = missionManager.findAllDomaine();
        return listDomaine;
    }

    @Override
    @GetMapping(value = "/mission/departements")
    public List<String> findDepartements() throws NotFoundException {
        List<String> listDepartements = missionManager.findDepartement();
        return listDepartements;
    }

    @Override
    @PostMapping(value = "/mission/communes")
    public List<String> findCommunes(@RequestBody String dep) throws NotFoundException {
        List<String> listCommunes = missionManager.findCommune(dep);
        return listCommunes;
    }

    @Override
    @PostMapping(value = "/association/inscription")
    public Association inscriptionAssociation(@RequestBody Association association) throws FunctionalException {
       logger.info(association.toString());
        association = inscriptionManager.inscriptionAsso(association);
        return association;
    }

    @Override
    @PostMapping(value = "/benevole/inscription")
    public Benevole inscriptionBenevole(@RequestBody Benevole benevole) throws FunctionalException {
        logger.info(benevole.toString());
        benevole = inscriptionManager.inscriptionBene(benevole);
        return benevole;
    }

    @Override
    @GetMapping(value = "/mission/id")
    public Mission getMissionById(@RequestParam Integer id) throws NotFoundException, FunctionalException {
       Mission mission = missionManager.getMissionById(id);
       return mission;

    }

    @Override
    @PostMapping(value = "/mission/addUser")
    public Boolean addUserToMission(@RequestBody Integer idInscription) throws NotFoundException, FunctionalException, MessagingException, IOException, TemplateException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        missionManager.addUserToMission(username, idInscription);
        missionManager.mailConsigne(idInscription,username);
        missionManager.mailInscriAsso(idInscription,username);
        return true;
    }

    @Override
    @PostMapping(value = "/mission/deleteUser")
    public Boolean deleteUserFromMission(@RequestBody Integer idInscription) throws NotFoundException, FunctionalException, MessagingException, IOException, TemplateException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        missionManager.deleteUserFromMission(username, idInscription);
        missionManager.mailDesinscriAsso(idInscription,username);
        return true;
    }

    @Override
    @GetMapping(value = "/user/getUser")
    public User getUser() throws NotFoundException, FunctionalException{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userManager.findOne(username);
        return  user;

    }

    @Override
    @GetMapping(value = "/mission/mailConsigne")
    public void mailConsigne(@RequestParam Integer idInscription, @RequestParam String username) throws NotFoundException, FunctionalException, MessagingException, IOException, TemplateException {

        missionManager.mailConsigne(idInscription,username);

    }

    @Override
    @PostMapping(value = "association/{idAssociation}/mission")
    public Mission saveMission(@RequestBody Mission mission, @PathVariable Integer idAssociation) throws NotFoundException, FunctionalException {
        return missionManager.saveMission(mission,idAssociation);
    }

    @Override
    @PostMapping(value = "mission/{idMission}/inscription")
    public Inscription saveInscription(@RequestBody Inscription inscription, @PathVariable Integer idMission) throws FunctionalException {
        return inscriptionManager.saveInscription(inscription,idMission);
    }

    @Override
    @DeleteMapping(value = "/mission/{idMission}")
    public void deleteMission(@PathVariable Integer idMission) throws NotFoundException {
        missionManager.deleteMission(idMission);
    }

    @Override
    @DeleteMapping(value = "/inscription/{idInscription}")
    public void deleteInscription(@PathVariable Integer idInscription) throws NotFoundException {
        inscriptionManager.deleteInscription(idInscription);
    }

    @Override
    @PostMapping(value = "/deleteInscriptions")
    public void deleteListeInscriptions(@RequestBody List<Integer> idsInscriptions) {
        inscriptionManager.deleteListeInscription(idsInscriptions);
    }

    @Override
    @GetMapping(value = "association/{idAssociation}/missions")
    public List<Mission> getMissionByIdAsso(@PathVariable Integer idAssociation) throws NotFoundException {
        return null;
    }
}
