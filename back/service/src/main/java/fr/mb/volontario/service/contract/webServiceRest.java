package fr.mb.volontario.service.contract;

import fr.mb.volontario.model.bean.*;
import fr.mb.volontario.model.dto.InscriptAssoDTO;
import fr.mb.volontario.model.dto.InscriptBeneDTO;
import fr.mb.volontario.model.dto.InscriptionDTO;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import fr.mb.volontario.model.recherche.RechercheMission;
import freemarker.template.TemplateException;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

/**
 * WebService
 */
public interface webServiceRest {
    /**
     * Recherche d'une mission
     * @param recherche
     * @return
     */
    List<Mission> rechercheMission(RechercheMission recherche) throws FunctionalException;

    /**
     * Récupération des domaines
     * @return liste des domaines
     * @throws NotFoundException
     */
    List<Domaine> findAllDomaine() throws NotFoundException;


    /**
     * Obtention des départements
     * @return
     * @throws NotFoundException
     */
    List<String> findDepartements() throws NotFoundException;


    /**
     * Obtention des villes en fonction du département
     * @param dep
     * @return
     * @throws NotFoundException
     */
    List<String> findCommunes(String dep) throws NotFoundException;

    /**
     * Inscription d'une association
     * @param association
     * @return l'association
     * @throws FunctionalException
     */
    Association inscriptionAssociation(InscriptAssoDTO association) throws FunctionalException;

    /**
     * Inscription d'un bénévole
     * @param benevole
     * @return benevole
     * @throws FunctionalException
     */
    Benevole inscriptionBenevole(InscriptBeneDTO benevole) throws FunctionalException;


    /**
     * Obtention d'une mission par son ID
     * @param id
     * @return
     * @throws NotFoundException
     * @throws FunctionalException
     */
    Mission getMissionById(Integer id) throws NotFoundException, FunctionalException;

    /**
     * Rajout d'un utilisateur à une liste d'inscription
     * @param idInscription
     * @throws NotFoundException
     * @throws FunctionalException
     */
    Boolean addUserToMission(Integer idInscription) throws NotFoundException, FunctionalException, MessagingException, IOException, TemplateException;


    /**
     * Desinscription d'un utilisateur à une mission
     * @param idInscription
     * @throws NotFoundException
     * @throws FunctionalException
     */
    Boolean deleteUserFromMission(@RequestBody Integer idInscription) throws NotFoundException, FunctionalException, MessagingException, IOException, TemplateException;

    /**
     * Obtention de l'utilisateur
     * @return
     * @throws NotFoundException
     * @throws FunctionalException
     */
    User getUser() throws NotFoundException, FunctionalException;


    /**
     * Envoi d'un mail de consigne à l'utilisateur
     * @param idInscription
     * @param username
     * @throws NotFoundException
     * @throws FunctionalException
     * @throws MessagingException
     * @throws IOException
     * @throws TemplateException
     */
    void mailConsigne(Integer idInscription, String username) throws NotFoundException, FunctionalException, MessagingException, IOException, TemplateException;

    /**
     *Sauvegarde d'une mission
     * @param mission
     * @param idAssociation
     * @return
     */
    Mission saveMission(Mission mission, Integer idAssociation) throws NotFoundException, FunctionalException;

    /**
     * Sauvegarde d'une inscription
     * @param inscription
     * @param idMission
     * @return
     * @throws NotFoundException
     */
    Inscription saveInscription(Inscription inscription, Integer idMission) throws NotFoundException, FunctionalException;

    /**
     * Suppression d'une mission
     * @param idMission
     * @throws NotFoundException
     */
    void deleteMission(Integer idMission) throws NotFoundException;

    /**
     * Suppression d'une inscription
     * @param idInscription
     * @throws NotFoundException
     */
    Boolean deleteInscription(Integer idInscription) throws NotFoundException;

    /**
     * Suppression d'une liste d'inscription
     * @param idsInscriptions
     */
    void deleteListeInscriptions(List<Integer>idsInscriptions);

    /**
     * Obtention des missions par association
     * @param idAssociation
     * @return
     * @throws NotFoundException
     */
    List<Mission> getMissionByIdAsso(Integer idAssociation) throws NotFoundException, FunctionalException;

    /**
     * Obtention des inscriptions par mission
     * @param idMission
     * @return
     */
    List<InscriptionDTO> getInscriptionsByIdMission(Integer idMission);


    /**
     * Obtention des associations
     * @param idAssociation
     * @return
     * @throws NotFoundException
     * @throws FunctionalException
     */
    Association getAssociation(Integer idAssociation) throws NotFoundException, FunctionalException;


    /**
     * sauvegarde d'une association
     * @param association
     * @return
     * @throws NotFoundException
     * @throws FunctionalException
     */
    Association saveAssociation( Association association) throws NotFoundException, FunctionalException;
}
