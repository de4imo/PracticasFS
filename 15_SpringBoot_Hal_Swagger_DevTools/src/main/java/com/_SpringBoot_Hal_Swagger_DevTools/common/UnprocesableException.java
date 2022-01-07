package com._SpringBoot_Hal_Swagger_DevTools.common;

import lombok.Getter;

import java.util.Date;

//@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
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