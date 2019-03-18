package fr.mb.volontario.dao.impl;

import fr.mb.volontario.dao.contract.DomaineCustomDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DomaineDAOImpl implements DomaineCustomDAO {

    @PersistenceContext
    EntityManager entityManager;

}
