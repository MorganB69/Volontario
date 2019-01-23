package fr.mb.volontario.dao.impl;

import fr.mb.volontario.dao.contract.MissionDAO;
import fr.mb.volontario.model.bean.Mission;

public class MissionDaoImpl extends AbstractDaoImpl<Mission> implements MissionDAO {
    public MissionDaoImpl(Class<Mission> entityClass) {
        super(entityClass);
    }
}
