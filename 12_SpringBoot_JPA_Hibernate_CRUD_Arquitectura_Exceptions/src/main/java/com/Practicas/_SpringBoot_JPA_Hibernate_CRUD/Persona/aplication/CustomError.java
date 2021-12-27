package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure.controllers.dto.output.PersonaDTOoutput;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@Setter
@Getter
public class CustomError /*extends ResponseEntity*/ {

    private Date timestamp;

    private int HttpCode;

    private String mensaje;


    public void setNotFoundException(){
        timestamp = new Date();
        HttpCode = 404;
        mensaje = "esto es not found exception";
    }

    public void setUnprocesableException(){
        timestamp = new Date();
        HttpCode = 422;
        mensaje = "esto es unpprocesable exception";
    }
}
