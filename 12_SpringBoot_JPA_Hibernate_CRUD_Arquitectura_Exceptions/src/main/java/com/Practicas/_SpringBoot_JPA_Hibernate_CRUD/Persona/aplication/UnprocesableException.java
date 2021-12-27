package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocesableException extends RuntimeException {
    public UnprocesableException(String message) {
        super(message);
    }
}