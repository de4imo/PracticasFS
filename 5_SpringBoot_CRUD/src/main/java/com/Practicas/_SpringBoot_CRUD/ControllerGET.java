package com.Practicas._SpringBoot_CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ControllerGET {
    @Autowired
    ServiceCRUD serviceCRUD;

    @RequestMapping(value = "/persona/id/{id}", method = GET)
    public Person getPersonByID(@PathVariable int id){
        return serviceCRUD.getPersonByID(id);
    }

    @RequestMapping(value = "/persona/nombre/{name}", method = GET)
    public List<Person> getPersonsByName(@PathVariable String name){
        return serviceCRUD.getPersonsByName(name);
    }
}
