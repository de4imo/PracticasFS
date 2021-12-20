package com.Practicas._SpringBoot_BS3._CicloVidaBeans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ClasePrincipal {

    @PostConstruct
    void funcion(){
        System.out.println("Hola desde la clase principal");
    }
}
