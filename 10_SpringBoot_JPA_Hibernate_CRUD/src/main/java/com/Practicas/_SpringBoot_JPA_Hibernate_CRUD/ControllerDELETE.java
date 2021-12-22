package com.Practicas._SpringBoot_JPA_Hibernate_CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class ControllerDELETE {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable long id){
        if(personaRepositorio.findById(id).isPresent()){
            personaRepositorio.deleteById(id);
        }else{new Exception("Usuario con ID:'" + id +"' no encontrado.");}
    }
}
