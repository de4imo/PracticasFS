package com.Practicas._SpringBoot_Properties_BS4_1Perfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ControllerParametros {

   @Value("${url: url no tiene valor}")
    String url;
   @Value("${password: var1 no tiene valor}")
    String password;


    @RequestMapping(value = "/parametros", method = GET)
    public String getParams(){
        return "Parámetros de 'application.properties':  " + url + " | " + password;
    }
}
