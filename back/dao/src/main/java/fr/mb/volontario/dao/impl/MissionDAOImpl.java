package fr.mb.volontario.dao.impl;

import fr.mb.volontario.dao.contract.MissionCustomDao;
import fr.mb.volontario.dao.contract.MissionDAO;
import fr.mb.volontario.model.bean.Mission;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MissionDAOImpl implements MissionCustomDao {
    @PersistenceContext
    EntityManager entityManager;
}
