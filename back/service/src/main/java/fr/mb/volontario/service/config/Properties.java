package fr.mb.volontario.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:credential.properties")
public class Properties {
}
