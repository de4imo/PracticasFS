package com.Practicas._SpringBoot_CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class ControllerPUT {
    @Autowired
    ServiceCRUD serviceCRUD;

    @RequestMapping(value = "/persona/{id}", method = PUT)
    void setID(@RequestBody Person person,
               @PathVariable int id){
     //   if (String.valueOf(id).length() > 2){

            if (IDexiste(id)) {
                System.out.println("Desde ControllerPut - ID"+id+" si existe, procedo a cambiar los datos...");
                serviceCRUD.getPersonByID(id).setAge(person.getAge());
                serviceCRUD.getPersonByID(id).setName(person.getName());
                serviceCRUD.getPersonByID(id).setTown(person.getTown());
            }

          //  System.out.println("ID cambiada correctamente.");
     //   }else{System.out.println("ID: " + id + " no existe"); }
    }

    public boolean IDexiste(int id){
       // return serviceCRUD.getPersonList().stream().filter(p -> p.getId()==id).findAny();
        if(serviceCRUD.getPersonByID(id)!=null){
            System.out.println(id+"existe");
            return true;
        }
        return false;
    }
}
