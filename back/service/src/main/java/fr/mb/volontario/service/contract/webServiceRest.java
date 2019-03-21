package fr.mb.volontario.service.contract;

import fr.mb.volontario.model.bean.*;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import fr.mb.volontario.model.recherche.RechercheMission;
import freemarker.template.TemplateException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    Association inscriptionAssociation(Association association) throws FunctionalException;

    /**
     * Inscription d'un bénévole
     * @param benevole
     * @return benevole
     * @throws FunctionalException
     */
    Benevole inscriptionBenevole(Benevole benevole) throws FunctionalException;


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
    Boolean addUserToMission(Integer idInscription) throws NotFoundException, FunctionalException;


    /**
     * Desinscription d'un utilisateur à une mission
     * @param idInscription
     * @throws NotFoundException
     * @throws FunctionalException
     */
    Boolean deleteUserFromMission(@RequestBody Integer idInscription) throws NotFoundException, FunctionalException;

    User getUser() throws NotFoundException, FunctionalException;


    void mailConsigne(Integer idInscription, String username) throws NotFoundException, FunctionalException, MessagingException, IOException, TemplateException;
}
