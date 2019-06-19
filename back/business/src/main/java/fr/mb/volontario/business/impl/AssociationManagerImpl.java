package fr.mb.volontario.business.impl;

import fr.mb.volontario.business.contract.AssociationManager;
import fr.mb.volontario.dao.contract.AssociationDAO;
import fr.mb.volontario.model.bean.Association;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class AssociationManagerImpl implements AssociationManager {

    @Autowired
    AssociationDAO associationDAO;

    @Override
    public Association getAssociation(Integer idAssociation) throws FunctionalException, NotFoundException {
        Assert.notNull(idAssociation, "l'id est obligatoire");
        Association association = associationDAO.findById(idAssociation).orElse(null);
        if (association==null) throw new NotFoundException("l'association n'existe pas");
        else return association;
    }
}
