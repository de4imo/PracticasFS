package com.Practicas._SpringBoot_JPA_Hibernate_CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerPOST {

    @Autowired
    PersonaRepositorio personaRepositorio;

    @PostMapping(value = "/addperson")
    public Persona addPersona(@RequestBody Persona pers) throws Exception {
        if (pers.getUsuario()!=null)
        {
            if (pers.getUsuario().length()<=10 && pers.getUsuario().length()>=6)
            {
                personaRepositorio.saveAndFlush(pers);

            }else{throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres ni menor de 6");}

        }else{throw new Exception("Usuario no puede ser nulo");}


        return pers;
    }
}
