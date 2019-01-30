package fr.mb.volontario.dao.impl;

import fr.mb.volontario.dao.contract.AdresseCustomDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AdresseDAOImpl implements AdresseCustomDAO {
    @PersistenceContext
    EntityManager entityManager;


}
