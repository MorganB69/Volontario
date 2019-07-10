package fr.mb.volontario.business.contract;

import fr.mb.volontario.model.bean.Association;
import fr.mb.volontario.model.bean.Benevole;
import fr.mb.volontario.model.bean.Inscription;
import fr.mb.volontario.model.dto.InscriptAssoDTO;
import fr.mb.volontario.model.dto.InscriptBeneDTO;
import fr.mb.volontario.model.dto.InscriptionDTO;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;

import java.util.List;

/**
 *
 */
public interface InscriptionManager {

    /**
     * Enregistrement d'une association
     * @param association
     * @return
     * @throws FunctionalException
     */
    Association inscriptionAsso(InscriptAssoDTO association) throws FunctionalException;

    /**
     * Inscription d'un bénévole à une mission
     * @param benevole
     * @return
     * @throws FunctionalException
     */
    Benevole inscriptionBene(InscriptBeneDTO benevole) throws FunctionalException;

    /**
     * Création d'une inscription
     * @param inscription
     * @return
     * @throws FunctionalException
     */
    Inscription saveInscription(Inscription inscription, Integer idMission) throws FunctionalException;

    /**
     * Suppression d'une inscription
     * @param idInscription
     * @throws NotFoundException
     */
    void deleteInscription(Integer idInscription) throws NotFoundException;

    /**
     * Suppression d'une liste d'inscription
     * @param idsInscription
     */
    void deleteListeInscription(List<Integer>idsInscription);

    /**
     * Obtention des inscriptions par mission
     * @param idMission
     * @return
     */
    List<InscriptionDTO> getInsctriptionByMission(Integer idMission);

    /**
     * Obtention des bénévoles par inscription
     * @param idInscription
     * @return
     */
    List<Benevole> getBenevoleByIdInscription(Integer idInscription) throws NotFoundException;
}
