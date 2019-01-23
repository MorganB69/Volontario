package fr.mb.volontario.dao.impl;

import fr.mb.volontario.dao.contract.BenevoleCustomDAO;
import fr.mb.volontario.dao.contract.BenevoleDAO;
import fr.mb.volontario.model.bean.Benevole;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BenevoleDaoImpl implements BenevoleCustomDAO {
    @PersistenceContext
    EntityManager entityManager;
}
