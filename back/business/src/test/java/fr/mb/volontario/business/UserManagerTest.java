package fr.mb.volontario.business;

import fr.mb.volontario.business.contract.UserManager;
import fr.mb.volontario.model.bean.Adresse;
import fr.mb.volontario.model.bean.Benevole;
import fr.mb.volontario.model.bean.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/ApplicationContextIntegrationTestManager.xml"})
@Transactional
public class UserManagerTest {

    @Autowired
    UserManager usermanager;

    User user = new User();
    Benevole bene = new Benevole();
    Adresse adresse = new Adresse();

    @Before
    public void setup(){
        adresse.setVoie("rue test");
        adresse.setCommune("test commune");
        adresse.setDepartement("test departement");
        adresse.setCode("00000");
        bene.setPrenom("test");
        bene.setNom("test");
        bene.setAdresse(adresse);
        user.setIdentifiant("usernameTest");
        user.setMdp("test");
        user.setMail("mail@mail.fr");
        user.setRole("BENE");
        user.setBenevole(bene);
    }

    @Test
    @Rollback
    public void userTest(){

        //Save
        usermanager.save(user);
        //FindOne
        User userTest = usermanager.findOne("usernameTest");
        Assert.assertNotNull("test findOne", userTest);
        //FindAll
        List<User> userList = usermanager.findAll();
        Assert.assertEquals(7, userList.size());
        //FindById
        userTest = usermanager.findById(1);
        Assert.assertEquals("Morgan", userTest.getIdentifiant());
        //Update
        userTest = usermanager.findOne("usernameTest");
        userTest.setMail("secondMailTest@gmail.fr");
        usermanager.update(userTest);
        usermanager.findOne("usernameTest");
        Assert.assertEquals("secondMailTest@gmail.fr", userTest.getMail());
        //Delete
        usermanager.delete(userTest.getIdUser());
        userTest=usermanager.findOne("usernameTest");
        Assert.assertNull(userTest);
    }
}
