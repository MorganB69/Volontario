package fr.mb.volontario.dao.impl;

import fr.mb.volontario.dao.contract.AssociationCustomDAO;
import fr.mb.volontario.model.bean.Association;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class AssociationDAOImpl implements AssociationCustomDAO {

    @PersistenceContext
    EntityManager entityManager;

}
