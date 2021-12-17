package com.Practicas._SpringBoot_CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ControllerPOST {
    @Autowired
    ServiceCRUD serviceCRUD;

    @RequestMapping(value = "/persona/", method = POST)
    void postUser(@RequestBody Person person){
        person.setId(serviceCRUD.getLastID()+1);
        serviceCRUD.setLastID(serviceCRUD.getLastID()+1);
        serviceCRUD.getPersonList().add(person);
        System.out.println("Persona recibida con post - nombre: " + person.getName() + ". Edad: " + person.getAge());
    }

}
