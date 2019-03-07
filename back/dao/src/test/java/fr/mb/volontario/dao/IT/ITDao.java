package fr.mb.volontario.dao.IT;

import fr.mb.volontario.dao.contract.*;
import fr.mb.volontario.model.bean.*;
import fr.mb.volontario.model.recherche.RechercheAdresse;
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
import java.util.List;
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
    User user = new User();


    @Before
    public void setUp(){



        //adresse set up
        adresse.setCode("69009");
        adresse.setCommune("Lyon");
        adresse.setVoie("rue test");
        adresse.setDepartement("69 - Rhônes");



        //Benevole set up
;
        benevole.setNom("Bobo");
        benevole.setPrenom("Morgan");

        user.setIdentifiant("bobo");
        user.setMdp("mdp");
        user.setMail("mail@mail.com");
        user.setRole("Benevole");


        benevole.setAdresse(adresse);
        benevole.setUser(user);
        adresse.getBenevoles().add(benevole);
        user.setBenevole(benevole);





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
    @Test
    public void getDepartmentTest() {
        Adresse adresse1 = new Adresse();
        adresse1.setCode("69009");
        adresse1.setCommune("Lyon");
        adresse1.setVoie("rue test");
        adresse1.setDepartement("69 - Rhônes");

        association.setPhoto("default");
        association.setDescription("test");
        association.setAdresse(adresse1);
        adresse1.getAssociations().add(association);

        Domaine domaine = new Domaine();
        domaine.setDescription("Aide");
        domaine.setNom("Aide");
        domaine.setIdDomaine(1);
        domaineDAO.save(domaine);
        association.getDomaines().add(domaine);
        association.setNom("test");
        association.setSiret("0000000000000");
        association.setWeb("test");
        associationDAO.save(association);

        Mission mission = new Mission();
        mission.setNom("test");
        mission.setCompetence("test");
        mission.setComplement("test");
        mission.setDescription("desc");
        mission.setDomaine(domaine);
        mission.setAdresse(adresse);
        adresse.getMissions().add(mission);
        mission.setAssociation(association);
        Mission mission2 = new Mission();
        mission2.setNom("test2");
        mission2.setCompetence("test2");
        mission2.setComplement("test2");
        mission2.setDescription("desc2");
        mission2.setDomaine(domaine);
        mission2.setAssociation(association);
        Adresse adresse2 = new Adresse();
        adresse2.setCode("01000");
        adresse2.setCommune("Rillieux");
        adresse2.setVoie("rue test 2");
        adresse2.setDepartement("01 - Ain");
        mission2.setAdresse(adresse2);
        adresse2.getMissions().add(mission2);
        missionDAO.save(mission);
        missionDAO.save(mission2);

        Adresse adresse3 = new Adresse();
        adresse3.setCode("01009");
        adresse3.setCommune("Villars");
        adresse3.setVoie("rue test 3");
        adresse3.setDepartement("01 - Ain");
        Adresse adresse4 = new Adresse();
        adresse4.setCode("69009");
        adresse4.setCommune("Lyon");
        adresse4.setVoie("rue test 3");
        adresse4.setDepartement("69 - Rhônes");
        //adresseDAO.save(adresse);
        //adresseDAO.save(adresse2);
        //adresseDAO.save(adresse3);
        //adresseDAO.save(adresse4);

        List<String> listTest = adresseDAO.getDepartement();
        List<String> listCom = adresseDAO.getCommunes(adresse2.getDepartement());
        for(String next: listTest){
            logger.info(next);
        }
        for(String next: listCom){
            logger.info(next);
        }
        Assert.assertTrue(listTest.size() == 2);
        Assert.assertTrue(listCom.size() == 1);


    }
}
