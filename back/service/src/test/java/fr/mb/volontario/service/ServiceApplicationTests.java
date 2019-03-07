package fr.mb.volontario.service;

import fr.mb.volontario.ServiceApplication;
import fr.mb.volontario.model.bean.LoginUser;
import fr.mb.volontario.service.config.FileStorageProperties;
import fr.mb.volontario.service.contract.AuthenticationController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public class ServiceApplicationTests {

    @Test
    public void contextLoads() {
    }



}

