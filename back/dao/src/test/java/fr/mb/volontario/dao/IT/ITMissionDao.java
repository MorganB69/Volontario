package fr.mb.volontario.dao.IT;

import fr.mb.volontario.dao.contract.MissionDAO;
import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.recherche.RechercheMission;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/ApplicationContextIntegrationTestDao.xml"})
public class ITMissionDao {

    Logger logger = LoggerFactory.getLogger(ITDao.class);

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Autowired
    MissionDAO missionDAO;

    List<Mission> listTest = new ArrayList<>();

    @Test
    public void rechercheMissionTest(){
        RechercheMission recherche = new RechercheMission();
        recherche.setDomaine(1);
        recherche.getDisponibilite().add(1);
        listTest = missionDAO.rechercheMission(recherche);

        Assert.assertTrue("liste non vide",!listTest.isEmpty());
        Assert.assertTrue("Test avec un domaine 1 et dispo 1", listTest.stream().anyMatch(o -> o.getIdMission()==(1)));

        recherche.setDomaine(1);
        recherche.getDisponibilite().clear();
        recherche.getDisponibilite().add(1);
        recherche.getDisponibilite().add(3);
        logger.info(Boolean.toString(recherche.getDisponibilite().contains(3)));
        listTest.clear();
        listTest =  missionDAO.rechercheMission(recherche);
        Assert.assertTrue("liste non vide",!listTest.isEmpty());
        Assert.assertTrue("Test avec un domaine 1 et dispo 1 et 3", listTest.stream().anyMatch(o -> o.getIdMission()==(1))&&listTest.stream().anyMatch(o -> o.getIdMission()==(3)));

    }
}
