package fr.mb.volontario.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mb.volontario.ServiceApplication;
import fr.mb.volontario.model.bean.LoginUser;
import fr.mb.volontario.service.contract.AuthenticationController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
@AutoConfigureMockMvc
public class AuthentificationIT {

    @Autowired
    MockMvc mvc;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private WebApplicationContext webApplicationContext;

    Logger logger = LoggerFactory.getLogger(AuthentificationIT.class);


    @Test
    public void registerTest() throws Exception {
        LoginUser user = new LoginUser();
        user.setUsername("Morgan");
        user.setPassword("azerty");
        String jsonInString = mapper.writeValueAsString(user);
        mvc.perform(post("/token/generate-token")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonInString))
                .andExpect(status().isOk());

        user.setPassword("az");
        jsonInString = mapper.writeValueAsString(user);
        mvc.perform(post("/token/generate-token")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonInString))
                .andExpect(status().isUnauthorized());
    }


}
