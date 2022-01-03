package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication;

import lombok.Getter;

import java.util.Date;

@Getter
public class UnprocesableException extends RuntimeException {

    CustomError customError;

    public UnprocesableException(String message) {
        super(message);

        customError = new CustomError();
        customError.setTimestamp(new Date());
        customError.setHttpCode(422);
        customError.setMensaje(message);
    }
}