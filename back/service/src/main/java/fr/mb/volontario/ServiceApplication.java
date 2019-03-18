package fr.mb.volontario;


import fr.mb.volontario.service.config.FileStorageProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan({"fr.mb.volontario.model","fr.mb.volontario.dao","fr.mb.volontario.service","fr.mb.volontario.business"})
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class ServiceApplication {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ServiceApplication.class);

        ApplicationContext applicationContext = SpringApplication.run(ServiceApplication.class, args);


    }

}

