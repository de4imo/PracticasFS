package com.Practicas._SpringBoot_JPA_Hibernate_CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerGET {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @GetMapping(value ="/getbyid/{id}")
    public Persona getPersonById(@PathVariable long id) throws Exception {
        return personaRepositorio.findById(id).orElseThrow(() -> new Exception("Usuario con ID:'" + id +"' no encontrado."));
    }

    @GetMapping(value ="/getbyname/{name}")
    public List<Persona> getPersonByName(@PathVariable String name) throws Exception {

        return personaRepositorio.findByName(name); //ById(id).orElseThrow(() -> new Exception("Usuario con nombre:'" + name +"' no encontrado."));
    }

    @GetMapping(value ="/getall")
    public List<Persona> getAllPersons() throws Exception {
        return personaRepositorio.findAll();
    }
}
