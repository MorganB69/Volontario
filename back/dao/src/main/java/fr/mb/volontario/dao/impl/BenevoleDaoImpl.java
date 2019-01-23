package fr.mb.volontario.dao.impl;

import fr.mb.volontario.dao.contract.BenevoleDAO;
import fr.mb.volontario.model.bean.Benevole;

public class BenevoleDaoImpl extends AbstractDaoImpl<Benevole> implements BenevoleDAO {
    public BenevoleDaoImpl(Class<Benevole> entityClass) {
        super(entityClass);
    }
}
