package fr.mb.volontario.dao.impl;

import fr.mb.volontario.dao.contract.UserCustomDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDAOImpl implements UserCustomDao {
    @PersistenceContext
    EntityManager entityManager;

    Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
}
