package fr.mb.volontario.dao.IT;


import fr.mb.volontario.dao.contract.MissionDAO;
import fr.mb.volontario.model.bean.Mission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)

@Transactional
public class ITMissionDAO {

    @Autowired
    MissionDAO missionDAO;

    @Test
    public void initContextTest(){

    }

    @Test
    public void createTest(){
        Mission missionTest = new Mission();

    }

}
