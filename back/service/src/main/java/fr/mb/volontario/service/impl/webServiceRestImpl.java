package fr.mb.volontario.service.impl;

import fr.mb.volontario.business.contract.MissionManager;
import fr.mb.volontario.dao.impl.MissionDAOImpl;
import fr.mb.volontario.model.bean.Domaine;
import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.exception.NotFoundException;
import fr.mb.volontario.model.recherche.RechercheMission;
import fr.mb.volontario.service.contract.webServiceRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/mission")
public class webServiceRestImpl implements webServiceRest {

    Logger logger = LoggerFactory.getLogger(webServiceRestImpl.class);

    @Autowired
    MissionManager missionManager;

    @Override
    @PostMapping(value="/recherche")
    public List<Mission> rechercheMission(RechercheMission recherche) {
        List<Mission> listMission = missionManager.rechercheMission(recherche);
        if (listMission.isEmpty()) logger.info("liste vide");



        return listMission;
    }

    @Override
    @GetMapping(value = "/domaines")
    public List<Domaine> findAllDomaine() throws NotFoundException {
        List<Domaine> listDomaine = missionManager.findAllDomaine();

        return listDomaine;
    }
}
