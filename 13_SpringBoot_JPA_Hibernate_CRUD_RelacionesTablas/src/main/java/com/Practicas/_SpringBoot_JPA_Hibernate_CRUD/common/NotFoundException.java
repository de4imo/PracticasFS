package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common;

import lombok.Getter;

import java.util.Date;

@Getter
public class NotFoundException extends RuntimeException {

    CustomError customError;

    public NotFoundException(String message) {
        super(message);

        //CustomError customError = new CustomError(HttpStatus.NOT_FOUND);
        this.customError = new CustomError();
        this.customError.setTimestamp(new Date());
        this.customError.setHttpCode(404);
        this.customError.setMensaje(message);
    }
}