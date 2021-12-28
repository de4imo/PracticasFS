package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication;

import lombok.Getter;

import java.util.Date;

@Getter
public class NotFoundException extends RuntimeException {

    CustomError customError;

    public NotFoundException(String message) {
        super(message);

        //CustomError customError = new CustomError(HttpStatus.NOT_FOUND);
        customError = new CustomError();
        customError.setTimestamp(new Date());
        customError.setHttpCode(404);
        customError.setMensaje(message);
    }
}