package fr.mb.volontario.business.impl;

import fr.mb.volontario.business.contract.MissionManager;
import fr.mb.volontario.dao.contract.MissionDAO;
import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.recherche.RechercheMission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MissionManagerImpl implements MissionManager {

    @Autowired
    MissionDAO missionDAO;

    @Override
    public List<Mission> rechercheMission(RechercheMission recherche) {


        return null;
    }
}
