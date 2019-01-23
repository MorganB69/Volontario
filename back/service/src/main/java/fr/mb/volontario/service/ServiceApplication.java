package fr.mb.volontario.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"fr.mb.volontario"})
public class ServiceApplication {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ServiceApplication.class);

        ApplicationContext applicationContext = SpringApplication.run(ServiceApplication.class, args);


    }

}

