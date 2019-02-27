package fr.mb.volontario.service.impl;

import fr.mb.volontario.business.contract.InscriptionManager;
import fr.mb.volontario.business.contract.MissionManager;
import fr.mb.volontario.dao.impl.MissionDAOImpl;
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
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
    public List<Mission> rechercheMission(@RequestBody RechercheMission recherche) {
        List<Mission> listMission = missionManager.rechercheMission(recherche);
        if (listMission.isEmpty()) logger.info("liste vide");
        if(!recherche.getDomaine().isEmpty()) logger.info("domaine"+ String.valueOf(recherche.getDomaine().size()));
        if(!listMission.isEmpty()) logger.info("missions"+ String.valueOf(listMission.size()));



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
       logger.info("inscription");
        inscriptionManager.inscriptionAsso(association);
        return association;
    }
}
