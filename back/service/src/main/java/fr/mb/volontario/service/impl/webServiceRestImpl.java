package fr.mb.volontario.service.impl;

import fr.mb.volontario.business.contract.MissionManager;
import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.recherche.RechercheMission;
import fr.mb.volontario.service.contract.webServiceRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class webServiceRestImpl implements webServiceRest {
    @Autowired
    MissionManager missionManager;

    @Override
    @RequestMapping(value = "/recherche", method = GET)
    public List<Mission> rechercheMission(@RequestParam(value="recherche") RechercheMission recherche) {
        List<Mission> listMission = missionManager.rechercheMission(recherche);
        return listMission;
    }
}
