package com._SpringBoot_Docker_PostgreSQL_V2.Person.infrastructure;

import com._SpringBoot_Docker_PostgreSQL_V2.Person.application.DTOs.PersonDTOinput;
import com._SpringBoot_Docker_PostgreSQL_V2.Person.application.DTOs.PersonDTOoutput;
import com._SpringBoot_Docker_PostgreSQL_V2.Person.application.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonServiceInterface personServiceInterface;

    @GetMapping(value ="/getpersonbyid/{id}")
    public Object getPersonById(@PathVariable String id) throws Exception {
        return personServiceInterface.getPersonById(id);
    }

    @GetMapping(value ="/getpersonbyname/{name}")
    public List<PersonDTOoutput> getPersonByName(@PathVariable String name) throws Exception {
        return personServiceInterface.getPersonsByName(name);
    }

    @GetMapping(value ="/getallpersons")
    public List<PersonDTOoutput> getAllPersons() throws Exception {
        return personServiceInterface.getAllPersons();
    }

    //POST
    @PostMapping(value = "/addperson")
    public PersonDTOoutput addPerson(@RequestBody PersonDTOinput pers) throws Exception {
        return personServiceInterface.addPerson(pers);
    }


    @PutMapping("/updateperson/{id}")
    public PersonDTOoutput updatePerson(@RequestBody PersonDTOinput pers, @PathVariable("id") String id) throws Exception {
        return personServiceInterface.updatePerson(pers, id);
    }


    @DeleteMapping("/deleteperson/{id}")
    public List<PersonDTOoutput> deletePerson(@PathVariable("id") String id) throws Exception {
        return personServiceInterface.deletePerson(id);
    }

    //Prueba:
    private String saludo = "primer hola";

    @PostMapping("/setsaludo/{saludo}")
    public String setSaludo(@PathVariable("saludo") String s){
        saludo = s;
        return saludo;
    }

    @GetMapping("/getsaludo")
    public String getSaludo(){
        return saludo;
    }
}
