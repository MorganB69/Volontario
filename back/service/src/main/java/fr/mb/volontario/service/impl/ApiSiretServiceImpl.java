package fr.mb.volontario.service.impl;

import fr.mb.volontario.model.bean.Token;
import fr.mb.volontario.service.contract.ApiSiretService;
import org.apache.tomcat.util.codec.binary.Base64;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin(origins =  "*")
@RequestMapping(value = "/siret")
public class ApiSiretServiceImpl implements ApiSiretService {
    @Value("${credential.consumerkey}")
    String consumerKey;
    @Value("${credential.secretkey}")
    String secretKey;






    @Override
    @GetMapping(value = "/token")
    public Token getToken() {
        String plainCreds = consumerKey + ":" + secretKey;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);



        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.insee.fr/token?grant_type=client_credentials";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic MnRaM0dLZlQ4UUJaQmY2ZHhHX01udFF0V2hRYTpUVXFSWm1oWXhBRjlvcmZYQmtfeHRVbE9jREFh");
        HttpEntity<String> request = new HttpEntity<String>(headers);


        ResponseEntity<Token> response = restTemplate.exchange(url, HttpMethod.POST, request, Token.class);


        Token token = response.getBody();

        return token;
    }
}
