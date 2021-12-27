package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure.controllers;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.CustomError;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.NotFoundException;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.PersonaServiceInterface;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.UnprocesableException;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure.controllers.dto.input.PersonaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure.controllers.dto.output.PersonaDTOoutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.ExceptionListener;
import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaServiceInterface personaServiceInterface;


    //GET
    @GetMapping(value ="/getbyid/{id}")
    public PersonaDTOoutput getPersonById(@PathVariable long id) throws Exception {
        return personaServiceInterface.getPersonById(id);
    }

    @GetMapping(value ="/getbyname/{name}")
    public List<PersonaDTOoutput> getPersonByName(@PathVariable String name) throws Exception {
        return personaServiceInterface.getPersonsByName(name);
    }

    @GetMapping(value ="/getall")
    public List<PersonaDTOoutput> getAllPersons() throws Exception {
        return personaServiceInterface.getAllPersons();
    }

    //POST
    @PostMapping(value = "/addperson")
    public PersonaDTOoutput addPersona(@RequestBody PersonaDTOinput pers) throws Exception {
        return personaServiceInterface.addPerson(pers);
    }

    //PUT
    @PutMapping("/update/id/{id}")
    public ResponseEntity<?> updatePersona(@RequestBody PersonaDTOinput pers, @PathVariable("id") Integer id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaServiceInterface.updatePersona(pers, id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error del servidor");
        }
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable("id") long id) throws Exception {
        try {
            personaServiceInterface.deletePersona(id);
            return ResponseEntity.status(HttpStatus.OK).body("Persona borrada con exito");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error del servidor");

        }
    }

    @ResponseBody
    @ExceptionHandler({NotFoundException.class})
    public CustomError handleExceptionNotFound() {
        System.out.println("hola desde el exception handler en CONTROLADORES, método handleExceptionNotFound");
        //CustomError customError = new CustomError(HttpStatus.NOT_FOUND);
        CustomError customError = new CustomError();
        customError.setNotFoundException();
        return customError;
    }

    @ResponseBody
    @ExceptionHandler({UnprocesableException.class})
    public CustomError handleUnprocesableException() {
        System.out.println("hola desde el exception handler en CONTROLADORES, método handleUnprocesableException");
        CustomError customError = new CustomError();
        customError.setUnprocesableException();
        return customError;
    }

}
