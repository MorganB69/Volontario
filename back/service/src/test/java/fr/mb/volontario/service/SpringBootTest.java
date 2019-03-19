package fr.mb.volontario.service;

import fr.mb.volontario.ServiceApplication;
import fr.mb.volontario.dao.contract.MissionDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@org.springframework.boot.test.context.SpringBootTest(classes = ServiceApplication.class)
@Transactional
public class SpringBootTest {

    @Autowired
    MissionDAO missionDAO;

    @Test
    public void initContext(){

    }

}
