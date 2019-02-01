package fr.mb.volontario.business.contract;

import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.recherche.RechercheMission;

import java.util.List;

public interface MissionManager {
    List<Mission> rechercheMission(RechercheMission recherche);
}
