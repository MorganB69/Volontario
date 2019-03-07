package fr.mb.volontario.business.contract;

import fr.mb.volontario.model.bean.Association;
import fr.mb.volontario.model.bean.Benevole;
import fr.mb.volontario.model.exception.FunctionalException;

public interface InscriptionManager {

    /**
     * Enregistrement d'une association
     * @param association
     * @return
     * @throws FunctionalException
     */
    Association inscriptionAsso(Association association) throws FunctionalException;

    Benevole inscriptionBene(Benevole benevole) throws FunctionalException;
}
