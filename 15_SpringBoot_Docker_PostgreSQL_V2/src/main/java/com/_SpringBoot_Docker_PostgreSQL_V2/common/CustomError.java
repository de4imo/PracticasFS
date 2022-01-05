package com._SpringBoot_Docker_PostgreSQL_V2.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CustomError {

    private Date timestamp;

    private int HttpCode;

    private String mensaje;
}
