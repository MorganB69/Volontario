package fr.mb.volontario.business;

import fr.mb.volontario.business.contract.MissionManager;
import fr.mb.volontario.dao.contract.InscriptionDAO;
import fr.mb.volontario.model.bean.Benevole;
import fr.mb.volontario.model.bean.Inscription;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

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


}
