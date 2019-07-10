package fr.mb.volontario.business;

import fr.mb.volontario.business.contract.InscriptionManager;
import fr.mb.volontario.dao.contract.DomaineDAO;
import fr.mb.volontario.model.bean.Adresse;
import fr.mb.volontario.model.bean.Association;
import fr.mb.volontario.model.bean.Benevole;
import fr.mb.volontario.model.bean.User;
import fr.mb.volontario.model.dto.InscriptAssoDTO;
import fr.mb.volontario.model.dto.InscriptBeneDTO;
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
        InscriptAssoDTO asso = new InscriptAssoDTO();
        asso.getAssociation().setNom("testNom");
        asso.getAssociation().setWeb("testWeb");
        asso.getAssociation().setSiret("00000000000000");
        asso.getAssociation().getDomaines().add(domaineDAO.findById(1).orElse(null));
        asso.getAssociation().setDescription("descriptionTest");
        asso.setIdentifiant("AssoTest");
        asso.setMail("test");
        asso.setRole("ASSO");
        asso.setMdp("mdp");

        Adresse adresse = new Adresse();
        adresse.setCode("00000");
        adresse.setDepartement("test");
        adresse.setCommune("test");
        adresse.setVoie("rue test");

        Association assoTest = inscriptionManager.inscriptionAsso(asso);
        Assert.assertEquals("testNom", assoTest.getNom());
        Assert.assertEquals("AssoTest", assoTest.getUsers().iterator().next().getIdentifiant());


    }

    @Test
    @Rollback
    public void inscriptionBeneTest() throws FunctionalException {
        InscriptBeneDTO bene = new InscriptBeneDTO();
        bene.getBenevole().setNom("testNom");
        bene.getBenevole().setPrenom("testprenom");
        bene.setMail("test");
        bene.setRole("BENE");
        bene.setMdp("mdp");
        bene.setIdentifiant("BeneTest");

        Adresse adresse = new Adresse();
        adresse.setCode("00000");
        adresse.setDepartement("test");
        adresse.setCommune("test");
        adresse.setVoie("rue test");


        Benevole beneTest = inscriptionManager.inscriptionBene(bene);
        Assert.assertEquals("testNom", beneTest.getNom());
        Assert.assertEquals("BeneTest", beneTest.getUser().getIdentifiant());


    }

}
