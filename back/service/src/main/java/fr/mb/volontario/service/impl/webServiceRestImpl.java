package fr.mb.volontario.service.impl;

import fr.mb.volontario.business.contract.InscriptionManager;
import fr.mb.volontario.business.contract.MissionManager;
import fr.mb.volontario.model.bean.Association;
import fr.mb.volontario.model.bean.Domaine;
import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import fr.mb.volontario.model.recherche.RechercheMission;
import fr.mb.volontario.service.contract.webServiceRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins =  "*")
public class webServiceRestImpl implements webServiceRest {

    Logger logger = LoggerFactory.getLogger(webServiceRestImpl.class);

    @Autowired
    MissionManager missionManager;
    @Autowired
    InscriptionManager inscriptionManager;

    @Override
    @PostMapping(value="/mission/recherche")
    @Secured("ROLE_ASSO")
    public List<Mission> rechercheMission(@RequestBody RechercheMission recherche) {
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
    @PostMapping(value = "/association/inscription")
    public Association inscriptionAssociation(@RequestBody Association association) throws FunctionalException {
       logger.info(association.toString());
        inscriptionManager.inscriptionAsso(association);
        return association;
    }
}
