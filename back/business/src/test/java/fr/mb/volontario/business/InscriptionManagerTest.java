package fr.mb.volontario.business;

import fr.mb.volontario.business.contract.InscriptionManager;
import fr.mb.volontario.dao.contract.DomaineDAO;
import fr.mb.volontario.model.bean.Adresse;
import fr.mb.volontario.model.bean.Association;
import fr.mb.volontario.model.bean.Benevole;
import fr.mb.volontario.model.bean.User;
import fr.mb.volontario.model.exception.FunctionalException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/ApplicationContextIntegrationTestManager.xml"})
@Transactional
public class InscriptionManagerTest {

    @Autowired
    InscriptionManager inscriptionManager;

    @Autowired
    DomaineDAO domaineDAO;

    @Test
    @Rollback
    public void inscriptionAssoTest() throws FunctionalException {
        Association asso = new Association();
        asso.setNom("testNom");
        asso.setWeb("testWeb");
        asso.setSiret("00000000000000");
        asso.getDomaines().add(domaineDAO.findById(1).orElse(null));
        asso.setDescription("descriptionTest");


        User user = new User();
        user.setMail("test");
        user.setRole("ASSO");
        user.setMdp("mdp");
        user.setIdentifiant("AssoTest");

        Adresse adresse = new Adresse();
        adresse.setCode("00000");
        adresse.setDepartement("test");
        adresse.setCommune("test");
        adresse.setVoie("rue test");

        asso.getUsers().add(user);
        user.setAssociation(asso);
        asso.setAdresse(adresse);

        Association assoTest = inscriptionManager.inscriptionAsso(asso);
        Assert.assertEquals("testNom", assoTest.getNom());
        Assert.assertEquals("AssoTest", assoTest.getUsers().iterator().next().getIdentifiant());


    }

    @Test
    @Rollback
    public void inscriptionBeneTest() throws FunctionalException {
        Benevole bene = new Benevole();
        bene.setNom("testNom");
        bene.setPrenom("testprenom");


        User user = new User();
        user.setMail("test");
        user.setRole("BENE");
        user.setMdp("mdp");
        user.setIdentifiant("BeneTest");

        Adresse adresse = new Adresse();
        adresse.setCode("00000");
        adresse.setDepartement("test");
        adresse.setCommune("test");
        adresse.setVoie("rue test");

        bene.setUser(user);
        user.setBenevole(bene);
        bene.setAdresse(adresse);

        Benevole beneTest = inscriptionManager.inscriptionBene(bene);
        Assert.assertEquals("testNom", beneTest.getNom());
        Assert.assertEquals("BeneTest", beneTest.getUser().getIdentifiant());


    }

}
