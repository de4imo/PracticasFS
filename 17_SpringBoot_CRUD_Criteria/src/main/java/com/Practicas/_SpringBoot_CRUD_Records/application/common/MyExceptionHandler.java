package com.Practicas._SpringBoot_CRUD_Records.application.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

        @ExceptionHandler(value = NotFoundException.class)
        public CustomError myException404(NotFoundException notFoundException) {
            System.out.println("Hola desde MyExceptionHandler (myException404) - message: " + notFoundException.getMessage());
            return notFoundException.getCustomError();
        }

        @ExceptionHandler(value = UnprocesableException.class)
        public CustomError myException422(UnprocesableException unprocesableException) {
            System.out.println("Hola desde MyExceptionHandler (myException422) -  message: " + unprocesableException.getMessage());
            return unprocesableException.getCustomError();
        }
}
