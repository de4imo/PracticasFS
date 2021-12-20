package com.Practicas._SpringBoot_BS3._CicloVidaBeans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ClaseSecundaria2 implements CommandLineRunner{

    @Bean
    CommandLineRunner ejecuta2() {
        return p -> {
            System.out.println("Hola desde la tercera clase.");
        };
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Argumentos recibidos: "+ args);
    }
}
