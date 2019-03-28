package fr.mb.volontario.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mb.volontario.ServiceApplication;
import fr.mb.volontario.business.contract.MissionManager;
import fr.mb.volontario.model.bean.LoginUser;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import fr.mb.volontario.model.recherche.RechercheMission;
import fr.mb.volontario.service.config.FileStorageProperties;
import fr.mb.volontario.service.contract.AuthenticationController;
import fr.mb.volontario.service.impl.FileStorageService;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = ServiceApplication.class)
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class ServiceApplicationTests {
    @Autowired
    MockMvc mvc;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    MissionManager missionManager;


    @Test
    public void contextLoadsTest() {
    }

    @Test
    public void mailTest() throws MessagingException, TemplateException, NotFoundException, FunctionalException, IOException {
        missionManager.mailConsigne(1,"Morgan");
        missionManager.mailInscriAsso(1,"Morgan");
        missionManager.mailDesinscriAsso(1,"Morgan");
    }

    @Test
    public void registerRestTest() throws Exception {
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

    @Test
    public void storageRestTest() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "imageTest.jpg", "image/jpg", "some jpg".getBytes());



        mvc.perform(multipart("/uploadFile")
                .file(file))
                .andExpect(status().is(200));

        mvc.perform(get("/downloadFile/imageTest.jpg"))
                .andExpect(status().is(200));
    }

    @Test
    public void getDomaineRestTest() throws Exception {
        mvc.perform(get("/mission/domaines"))
                .andExpect(status().is(200));
    }

    @Test
    public void rechercheMissionRestTest() throws Exception {
        RechercheMission recherche = new RechercheMission();
        recherche.getDomaine().add(1);
        recherche.getDisponibilite().add(1);
        recherche.setCommune("Muret");
        recherche.setDepartement("31, Haute-Garonne, Occitanie (Midi-Pyrénées)");
        String jsonInString = mapper.writeValueAsString(recherche);
        mvc.perform(post("/mission/recherche")
        .content(jsonInString)
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

    @Test
    public void findCommuneDepRestTest() throws Exception {
        mvc.perform(get("/mission/departements"))
                .andExpect(status().is(200));

        String dep = "69, Rhône, Auvergne-Rhône-Alpes (Rhône-Alpes)";
        String jsonInString = mapper.writeValueAsString(dep);
        mvc.perform(post("/mission/communes")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonInString))
                .andExpect(status().is(200));


    }

    @Test
    public void findMissionRestTest() throws Exception {
        String id = "1";
        mvc.perform(get("/mission/id")
        .param("id", id))
                .andExpect(status().is(200));
    }


}

