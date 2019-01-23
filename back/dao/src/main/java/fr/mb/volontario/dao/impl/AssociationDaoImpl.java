package fr.mb.volontario.dao.impl;

import fr.mb.volontario.dao.contract.AssociationDAO;
import fr.mb.volontario.model.bean.Association;

public class AssociationDaoImpl extends AbstractDaoImpl<Association> implements AssociationDAO {

    public AssociationDaoImpl(Class<Association> entityClass) {
        super(entityClass);
    }
}
