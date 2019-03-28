package fr.mb.volontario.business.contract;

import fr.mb.volontario.model.bean.Domaine;
import fr.mb.volontario.model.bean.Inscription;
import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.bean.User;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import fr.mb.volontario.model.recherche.RechercheAdresse;
import fr.mb.volontario.model.recherche.RechercheMission;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.IOException;
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

    void addUserToMission(String username, Integer inscriptionId) throws FunctionalException, NotFoundException;

    void deleteUserFromMission(String username, Integer idInscription) throws FunctionalException, NotFoundException;


    /**
     * Mail de consigne pour le bénévole
     * @param inscriptionId
     * @param username
     * @throws MessagingException
     * @throws IOException
     * @throws TemplateException
     * @throws FunctionalException
     * @throws NotFoundException
     */
    //-----------Mail------------------
    void mailConsigne(Integer inscriptionId, String username) throws MessagingException, IOException, TemplateException, FunctionalException, NotFoundException;


    /**
     * Mail d'inscription à l'asso
     * @param inscriptionId
     * @param username
     * @throws MessagingException
     * @throws IOException
     * @throws TemplateException
     * @throws FunctionalException
     * @throws NotFoundException
     */
    void mailInscriAsso(Integer inscriptionId, String username) throws MessagingException, IOException, TemplateException, FunctionalException, NotFoundException;


    /**
     * Mail de désinscription à l'asso
     * @param inscriptionId
     * @param username
     * @throws NotFoundException
     * @throws MessagingException
     * @throws IOException
     * @throws TemplateException
     */
    void mailDesinscriAsso(Integer inscriptionId, String username) throws NotFoundException, MessagingException, IOException, TemplateException;
}
