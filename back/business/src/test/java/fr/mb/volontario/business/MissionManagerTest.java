package fr.mb.volontario.business;

import fr.mb.volontario.business.contract.MissionManager;
import fr.mb.volontario.dao.contract.InscriptionDAO;
import fr.mb.volontario.model.bean.Benevole;
import fr.mb.volontario.model.bean.Inscription;
import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import fr.mb.volontario.model.recherche.RechercheMission;
import freemarker.template.TemplateException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/ApplicationContextIntegrationTestManager.xml"})
public class MissionManagerTest {

    @Autowired
    MissionManager missionManager;

    @Autowired
    InscriptionDAO inscriptionDAO;

    @Test
    public void initContext(){

    }

    @Test
    @Transactional
    @Rollback
    public void addUserToMissionTest() throws NotFoundException, FunctionalException {
        try{
            missionManager.addUserToMission("Carole", 1);
        }
        catch (FunctionalException e){
            Assert.assertTrue(e.getMessage().equals("il n'y a plus de place disponible"));
        }
        try{
            missionManager.addUserToMission("Morgan", 2);
        }
        catch (FunctionalException e){
            Assert.assertTrue(e.getMessage().equals("L'utilisateur est déjà inscrit à cette mission"));
        }

        missionManager.addUserToMission("Carole", 2);
        Inscription inscription = inscriptionDAO.findById(2).orElseThrow(NotFoundException::new);
        Boolean verif = false;
        for (Benevole bene: inscription.getBenevoles()
             ) {
            if(bene.getUser().getIdentifiant().equals("Carole")) verif=true;
        }
        Assert.assertTrue(verif);

    }

    @Test
    @Transactional
    @Rollback
    public void deleteUserFromMissionTest() throws NotFoundException, FunctionalException {
        missionManager.deleteUserFromMission("Morgan", 1);
        Inscription inscription = inscriptionDAO.findById(1).orElseThrow(NotFoundException::new);
        Boolean verif = false;
        for (Benevole bene: inscription.getBenevoles()
        ) {
            if(bene.getUser().getIdentifiant().equals("Morgan")) verif=true;
        }
        Assert.assertFalse(verif);

    }

    @Test
    @Rollback
    public void rechercheMissionTest() throws FunctionalException {
        RechercheMission recherche = new RechercheMission();
        recherche.getDomaine().add(1);
        recherche.getDisponibilite().add(1);
        recherche.setCommune("Muret");
        recherche.setDepartement("31, Haute-Garonne, Occitanie (Midi-Pyrénées)");
        List<Mission> listTest = missionManager.rechercheMission(recherche);

        Assert.assertTrue("liste non vide",!listTest.isEmpty());

        recherche=null;
        try {
            listTest = missionManager.rechercheMission(recherche);
        }
        catch (Exception e){
            Assert.assertEquals("Une erreur est parvenue dans la recherche",e.getMessage());
        }
    }

    @Test
    @Rollback
    public void findDepartementTest() throws NotFoundException {
        List<String> listDep = missionManager.findDepartement();
        Assert.assertEquals(2, listDep.size());

    }

    @Test
    @Rollback
    public void findCommuneTest() throws NotFoundException {
        String departement = "69, Rhône, Auvergne-Rhône-Alpes (Rhône-Alpes)";
        List<String> listCom = missionManager.findCommune(departement);
        Assert.assertEquals(1, listCom.size());
    }

    @Test
    @Rollback
    public void findMissionByIdTest() throws NotFoundException, FunctionalException {
        Mission mission = missionManager.getMissionById(1);
        Assert.assertEquals("Assistante Maison Retraite",mission.getNom());
        try{
            mission = missionManager.getMissionById(4562);
        }
        catch (NotFoundException e){
            Assert.assertEquals("Mission non trouvée",e.getMessage());
        }
        try{
            mission = missionManager.getMissionById(0);
        }
        catch (FunctionalException e){
            Assert.assertEquals("erreur de donnée, l'id est incorrect",e.getMessage());
        }


    }



}
