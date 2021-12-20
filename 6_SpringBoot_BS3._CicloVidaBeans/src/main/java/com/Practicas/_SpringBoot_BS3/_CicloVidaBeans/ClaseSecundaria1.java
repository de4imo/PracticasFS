package com.Practicas._SpringBoot_BS3._CicloVidaBeans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ClaseSecundaria1 {

    @Bean
    CommandLineRunner ejecuta1() {
        return p -> {
            System.out.println("Hola desde clase secundaria.");
        };
    }
}
