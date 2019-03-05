package fr.mb.volontario.business.contract;

import fr.mb.volontario.model.bean.Domaine;
import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import fr.mb.volontario.model.recherche.RechercheMission;

import java.util.List;

/**
 * Manager des missions
 */
public interface MissionManager {
    /**
     * Obtention des missions en fonction d'une recherche
     * @param recherche
     * @return
     */
    List<Mission> rechercheMission(RechercheMission recherche) throws FunctionalException;

    /**
     * Obtention de tous les domaines
     * @return
     */
    List<Domaine> findAllDomaine() throws NotFoundException;
}
