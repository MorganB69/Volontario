package fr.mb.volontario.service.contract;

import fr.mb.volontario.model.bean.Association;
import fr.mb.volontario.model.bean.Benevole;
import fr.mb.volontario.model.bean.Domaine;
import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import fr.mb.volontario.model.recherche.RechercheAdresse;
import fr.mb.volontario.model.recherche.RechercheMission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    Benevole inscriptionBenevole(@RequestBody Benevole benevole) throws FunctionalException;
}
