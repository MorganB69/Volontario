package fr.mb.volontario.service.contract;

import fr.mb.volontario.model.bean.Domaine;
import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.exception.NotFoundException;
import fr.mb.volontario.model.recherche.RechercheMission;

import java.util.List;

public interface webServiceRest {
    List<Mission> rechercheMission(RechercheMission recherche);
    List<Domaine> findAllDomaine() throws NotFoundException;
}
