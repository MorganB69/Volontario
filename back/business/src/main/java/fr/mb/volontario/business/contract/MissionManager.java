package fr.mb.volontario.business.contract;

import fr.mb.volontario.model.bean.Domaine;
import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import fr.mb.volontario.model.recherche.RechercheAdresse;
import fr.mb.volontario.model.recherche.RechercheMission;

import javax.transaction.Transactional;
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


    /**
     * Obtention des départements et communes des missions
     * @return
     * @throws NotFoundException
     */
    List<String> findDepartement() throws NotFoundException;


    /**
     * Recherche de la commune en fonction du département
     * @param departement
     * @return
     * @throws NotFoundException
     */
    List<String> findCommune(String departement) throws NotFoundException;

    /**
     * Obtention d'une mission by id
     * @param id
     * @return
     * @throws NotFoundException
     */
    Mission getMissionById(Integer id) throws NotFoundException, FunctionalException;
}
