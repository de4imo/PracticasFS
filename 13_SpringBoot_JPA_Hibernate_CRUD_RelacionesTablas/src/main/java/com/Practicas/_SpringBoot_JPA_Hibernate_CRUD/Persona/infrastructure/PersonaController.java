package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.CustomError;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.NotFoundException;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.PersonaServiceInterface;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.UnprocesableException;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.input.PersonaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.output.PersonaDTOoutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaServiceInterface personaServiceInterface;


    //GET
    @GetMapping(value ="/getpersonbyid/{id}")
    public PersonaDTOoutput getPersonById(@PathVariable String id) throws Exception {
        return personaServiceInterface.getPersonById(id);
    }

    @GetMapping(value ="/getpersonbyname/{name}")
    public List<PersonaDTOoutput> getPersonByName(@PathVariable String name) throws Exception {
        return personaServiceInterface.getPersonsByName(name);
    }

    @GetMapping(value ="/getallpersons")
    public List<PersonaDTOoutput> getAllPersons() throws Exception {
        return personaServiceInterface.getAllPersons();
    }

    //POST
    @PostMapping(value = "/addperson")
    public PersonaDTOoutput addPersona(@RequestBody PersonaDTOinput pers) throws Exception {
        return personaServiceInterface.addPerson(pers);
    }

    //PUT
    @PutMapping("/updateperson/{id}")
    public ResponseEntity<?> updatePersona(@RequestBody PersonaDTOinput pers, @PathVariable("id") String id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaServiceInterface.updatePersona(pers, id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error del servidor");
        }
    }

    //DELETE
    @DeleteMapping("/deleteperson/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable("id") String id) throws Exception {
        try {
            personaServiceInterface.deletePersona(id);
            return ResponseEntity.status(HttpStatus.OK).body("Persona borrada con exito");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error del servidor");
        }
    }
}
