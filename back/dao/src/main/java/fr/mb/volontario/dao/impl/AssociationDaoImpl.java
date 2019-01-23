package fr.mb.volontario.dao.impl;

import fr.mb.volontario.dao.contract.AssociationCustomDAO;
import fr.mb.volontario.model.bean.Association;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class AssociationDaoImpl implements AssociationCustomDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Association rechercheAssociation() {
        return null;
    }
}
