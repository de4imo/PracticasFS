package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure.controllers.dto.output.PersonaDTOoutput;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Setter
@Getter
@Component
public class CustomError {

    private Date timestamp;

    private int HttpCode;

    private String mensaje;

    /*@Autowired(required = false)
    NotFoundException notFoundException;

    @Autowired(required = false)
    UnprocesableException unprocesableException;*/


    /*public void getNotFoundException(){
        timestamp = new Date();
        HttpCode = 404;
        mensaje = "esto es not found exception";
    }

    public UnprocesableException getUnprocesableException(){
        timestamp = new Date();
        HttpCode = 422;
        mensaje = "esto es unpprocesable exception";
    }*/
}
