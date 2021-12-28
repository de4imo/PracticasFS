package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.CustomError;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.NotFoundException;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.UnprocesableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

        @ExceptionHandler(value = NotFoundException.class)
        public CustomError myException404(NotFoundException notFoundException) {
            System.out.println("Hola desde MyExceptionHandler. ({ NotFoundException.class}), probando si recibo parámetros, código error: " + notFoundException.getCustomError().getHttpCode());
            return notFoundException.getCustomError();
        }

        @ExceptionHandler({ UnprocesableException.class})
        public CustomError myException422(UnprocesableException unprocesableException) {
            System.out.println("Hola desde MyExceptionHandler.  ({ UnprocesableException.class}), probando si recibo parámetros, código error: " + unprocesableException.getCustomError().getHttpCode());
            return unprocesableException.getCustomError();
        }
}
