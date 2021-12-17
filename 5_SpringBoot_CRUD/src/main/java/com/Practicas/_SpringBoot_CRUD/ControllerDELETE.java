package com.Practicas._SpringBoot_CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class ControllerDELETE {
    @Autowired
    ServiceCRUD serviceCRUD;

    @RequestMapping(value = "/persona/{id}", method = DELETE)
    public void deleteByID(@PathVariable int id){
        Person pers = serviceCRUD.getPersonByID(id);

        if (pers != null) {
            String name = pers.getName();
            serviceCRUD.getPersonList().remove(pers);
            System.out.println(name + " ha sido eliminado correctamente.");
        }else{
            System.out.println("No existe persona con ID = " + id);
        }
    }

}
