package fr.mb.volontario.dao.IT;

import fr.mb.volontario.dao.contract.*;
import fr.mb.volontario.model.bean.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/ApplicationContextTestDao.xml"})
@Transactional
public class ITDao {

    @Autowired
    EntityManager entityManager;
    @Autowired
    MissionDAO missionDAO;
    @Autowired
    BenevoleDAO benevoleDAO;
    @Autowired
    AssociationDAO associationDAO;
    @Autowired
    DomaineDAO domaineDAO;
    @Autowired
    AdresseDAO adresseDAO;

    Association association = new Association();
    Mission mission = new Mission();
    Benevole benevole = new Benevole();
    Domaine domaine = new Domaine();
    Adresse adresse = new Adresse();


    @Before
    public void setUp(){
        //adresse set up
        adresse.setCode("69009");
        adresse.setCommune("Lyon");
        adresse.setVoie("rue test");
        adresse.setDepartement("Rhônes");
        adresse.setRegion("Rhônes-Alpes");

        //Benevole set up

        LocalDate date = LocalDate.now();
        benevole.setDateNaissance(date);
        benevole.setIdentifiant("Momo");
        benevole.setMail("momo@gmail.fr");
        benevole.setNom("Bobo");
        benevole.setMdp("azera");
        benevole.setPrenom("Morgan");

        benevole.setAdresse(adresse);
        adresse.getBenevoles().add(benevole);


    }
    @Test
    public void initContext(){
    }

    @Test
    public void persistBenevole(){
       benevoleDAO.save(benevole);

    }
}
