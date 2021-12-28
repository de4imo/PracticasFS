package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common;

import lombok.Getter;

import java.util.Date;

@Getter
public class NotFoundException extends RuntimeException {

    CustomError customError;

    public NotFoundException(String message) {
        super(message);

        //CustomError customError = new CustomError(HttpStatus.NOT_FOUND);
        CustomError customError = new CustomError();
        customError.setTimestamp(new Date());
        customError.setHttpCode(404);
        customError.setMensaje("not found");
    }

    /*CustomError getCustomError(){
        CustomError customError = new CustomError(HttpStatus.NOT_FOUND);
        customError.setTimestamp(new Date());
        customError.setHttpCode(404);
        customError.setMensaje("not found");
        return customError;
    }*/
}