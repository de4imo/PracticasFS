package com.Practicas._SpringBoot_Properties_BS4_1Perfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Component
@RestController
@Profile("p1")
public class Perfil1 implements Perfiles{

    String perfil = "perfil1";

    @Override
    @RequestMapping(value = "/perfil", method = GET)
    public String miFuncion() {
        return perfil;
    }

/*    @RequestMapping(value = "/perfil", method = GET)
    public String getParameetros(){
        return miFuncion();
    }*/
}
