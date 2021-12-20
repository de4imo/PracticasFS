package com.Practicas._SpringBoot_Properties_BS4_1Perfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Component
@RestController
@Profile("p2")
public class Perfil2 implements Perfiles{

    String perfil = "perfil2";

    @Override
    @RequestMapping(value = "/perfil", method = GET)
    public String miFuncion() {
        return perfil;
    }
}
