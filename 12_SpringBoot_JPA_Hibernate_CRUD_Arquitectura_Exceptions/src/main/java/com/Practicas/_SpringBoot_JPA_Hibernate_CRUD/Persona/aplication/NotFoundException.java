package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
public class NotFoundException extends RuntimeException {

    @Autowired
    CustomError customError;// = new CustomError();


    public NotFoundException(String message) {
        super(message);

        //CustomError customError = new CustomError(HttpStatus.NOT_FOUND);
        customError = new CustomError();
        customError.setTimestamp(new Date());
        customError.setHttpCode(404);
        customError.setMensaje(message);
    }

    /*CustomError getCustomError(){
        CustomError customError = new CustomError(HttpStatus.NOT_FOUND);
        customError.setTimestamp(new Date());
        customError.setHttpCode(404);
        customError.setMensaje("not found");
        return customError;
    }*/
}