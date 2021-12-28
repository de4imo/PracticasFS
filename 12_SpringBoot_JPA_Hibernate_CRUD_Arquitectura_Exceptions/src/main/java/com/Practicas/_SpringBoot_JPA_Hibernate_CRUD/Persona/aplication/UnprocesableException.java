package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
public class UnprocesableException extends RuntimeException {

    @Autowired
    CustomError customError ;//= new CustomError();

    public UnprocesableException(String message) {

        customError = new CustomError();
        customError.setTimestamp(new Date());
        customError.setHttpCode(422);
        customError.setMensaje(message);
    }
}