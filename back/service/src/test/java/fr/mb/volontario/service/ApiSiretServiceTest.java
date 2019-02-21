package fr.mb.volontario.service;

import fr.mb.volontario.model.bean.Token;
import fr.mb.volontario.service.contract.ApiSiretService;
import fr.mb.volontario.service.impl.ApiSiretServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApiSiretServiceTest {


    ApiSiretServiceImpl apiSiretService = new ApiSiretServiceImpl();

    @Test
    public void getTokenTest(){
    Token token = apiSiretService.getToken();
        Assert.assertNotNull(token);

    }
}
