package fr.mb.volontario.dao.IT;

import fr.mb.volontario.dao.contract.UserDao;
import fr.mb.volontario.model.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/ApplicationContextIntegrationTestDao.xml"})
public class ITUserDao {

    @Autowired
    UserDao userDao;

    @Test
    @Transactional
    public void persistUserTest(){
        User user = new User();
        user.setRole("Association");
        user.setMail("test.test@gmail.fr");
        user.setMdp("test");
        user.setIdentifiant("Identifiant");
        userDao.save(user);
    }

}
