package com.Practicas._SpringBoot_JPA_Hibernate_CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPUT {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @PutMapping("/update/id/{id}")
    public Persona update(@PathVariable long id,
                          @RequestBody Persona persona) throws Exception {
        //1ºBusca si existe usuario con esa id, y se comprueba que el objeto enviado no esté vacío
        //2ºComprobamos que el nombre de usuario no sea nulo
        //3ºComprobamos que la longitud de usuario está entré 6 y 10

        if (personaRepositorio.findById(id).isPresent() && persona!=null)
        {
            if (persona.getUsuario()!=null)
            {
                if (persona.getUsuario().length()<=10 && persona.getUsuario().length()>=6)
                {
                    persona.setId(id);
                    personaRepositorio.saveAndFlush(persona);
                    return persona;

                }else{throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres ni menor de 6");}

            }else{throw new Exception("Usuario no puede ser nulo");}

        }else{throw new Exception("La id del usuario que quieres cambiar no existe o estás enviando un objeto vacío");}

    }
}
