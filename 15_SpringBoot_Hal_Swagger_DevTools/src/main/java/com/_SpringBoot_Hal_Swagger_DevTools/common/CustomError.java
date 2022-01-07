package com._SpringBoot_Hal_Swagger_DevTools.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CustomError /*extends ResponseEntity*/ {

    private Date timestamp;

    private int HttpCode;

    private String mensaje;
}
