package com.Practicas._SpringBoot_Properties_BS4_1Perfiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@PropertySource("classpath:miConfiguracion")
@RestController
public class ControllerMiConfig {

    @Value("${valor1: valor1 no tiene valor}")
    String valor1;

    @Value("${valor2: valor2 no tiene valor}")
    String valor2;

    @RequestMapping(value = "/miconfiguracion", method = GET)
    public String getParams(){
        return "Parámetros de 'miConfiguracion.properties':  " + valor1 + "  |  " + valor2;
    }
}
