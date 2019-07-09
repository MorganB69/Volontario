package fr.mb.volontario.business.contract;

import fr.mb.volontario.model.bean.Association;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;

public interface AssociationManager {
    Association getAssociation(Integer idAssociation) throws FunctionalException, NotFoundException;

    Association saveAssociation(Association association);
}
