package fr.mb.volontario.dao.IT;

import fr.mb.volontario.dao.contract.*;
import fr.mb.volontario.model.bean.*;
import org.hibernate.LazyInitializationException;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.LogManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/ApplicationContextTestDao.xml"})
public class ITDao {
    Logger logger = LoggerFactory.getLogger(ITDao.class);

    @Rule
    public final ExpectedException exception = ExpectedException.none();

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
        //Get benevole and adress entries
        Optional<Adresse> adresseData=adresseDAO.findById(1);
        adresse= adresseData.orElse(null);
        //TEST
        Assert.assertNotNull("vérification que l'adresse est enregistrée en cascade en db", adresse);


        Optional<Benevole> benevoleData=benevoleDAO.findById(1);
        benevole= benevoleData.orElse(null);
        Assert.assertNotNull("vérification que le bénévole est enregistré en db",benevole);

        String rue="";
        exception.expect(LazyInitializationException.class);
        rue=benevole.getAdresse().getVoie();

    }
}
