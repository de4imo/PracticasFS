package com._SpringBoot_Hal_Swagger_DevTools.common;

import lombok.Getter;

import java.util.Date;

@Getter
public class NotFoundException extends RuntimeException {

    CustomError customError;

    public NotFoundException(String message) {
        super(message);

        this.customError = new CustomError();
        this.customError.setTimestamp(new Date());
        this.customError.setHttpCode(404);
        this.customError.setMensaje(message);
    }
}