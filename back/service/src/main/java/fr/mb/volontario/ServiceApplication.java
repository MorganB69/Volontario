package fr.mb.volontario;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"fr.mb.volontario.model","fr.mb.volontario.dao","fr.mb.volontario.service","fr.mb.volontario.business"})
public class ServiceApplication {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ServiceApplication.class);

        ApplicationContext applicationContext = SpringApplication.run(ServiceApplication.class, args);


    }

}

