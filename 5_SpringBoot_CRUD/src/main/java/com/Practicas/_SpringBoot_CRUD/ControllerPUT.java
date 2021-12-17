package com.Practicas._SpringBoot_CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class ControllerPUT {
    @Autowired
    ServiceCRUD serviceCRUD;

    @RequestMapping(value = "/persona/{id}", method = PUT)
    void setID(@RequestBody Person person,
               @PathVariable int id){
        Person pers = serviceCRUD.getPersonByID(id);
        if (pers != null) {
            if(person.getAge() !=null){ pers.setAge(person.getAge()); }

            if(person.getName() !=null){ pers.setName(person.getName());}

            if(person.getTown() != null){ pers.setTown(person.getTown());}
        }else{
            System.out.println("Persona con ID:" + id + " no existe.");
        }
    }
}
