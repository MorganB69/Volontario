package fr.mb.volontario.business.impl;

import fr.mb.volontario.business.contract.InscriptionManager;
import fr.mb.volontario.dao.contract.AssociationDAO;
import fr.mb.volontario.model.bean.Association;
import fr.mb.volontario.model.exception.FunctionalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class InscriptionManagerImpl implements InscriptionManager {

    @Autowired
    AssociationDAO associationDAO;

    @Override
    @Transactional
    public Association inscriptionAsso(Association association) throws FunctionalException {
        if (association==null) throw new FunctionalException("L'association est null");
        else associationDAO.save(association);

        return association;
    }
}
