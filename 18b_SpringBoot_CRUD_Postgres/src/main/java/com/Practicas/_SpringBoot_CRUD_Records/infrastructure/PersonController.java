package com.Practicas._SpringBoot_CRUD_Records.infrastructure;


import com.Practicas._SpringBoot_CRUD_Records.application.DTOs.PersonaDTOinput;
import com.Practicas._SpringBoot_CRUD_Records.application.DTOs.PersonaDTOoutput;
import com.Practicas._SpringBoot_CRUD_Records.application.PersonService;
import com.Practicas._SpringBoot_CRUD_Records.domain.Person;
import com.Practicas._SpringBoot_CRUD_Records.domain.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*")     //Añadido para la aplicacion de angular
@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    public static final String GREATER_THAN="greater";
    public static final String LESS_THAN="less";
    public static final String EQUAL="equal";

    //‘user’, ‘name’, ‘surname‘ o ‘fecha creación
    @GetMapping("/get")
    public List<PersonaDTOoutput> getData(
            @RequestParam(value="user", required=false) String user,
            @RequestParam(value="name", required=false) String name,
            @RequestParam(value="surname", required=false) String surname,
            @RequestParam(value="created_date", required=false) @DateTimeFormat(pattern="yyyy-MM-dd")/*@DateTimeFormat(pattern="dd-MM-yyyy")*/ Date createdDate,
            @RequestParam(value="dateCondition", required=false) String dateCondition,
            @RequestParam(value="page", required = true) int page) throws Exception
    {
        return personService.getByCriteria(user, name, surname, createdDate, dateCondition, page);
    }

    @GetMapping(value ="/getbyid/{id}")
    public PersonaDTOoutput getPersonById(@PathVariable long id) throws Exception {
        return personService.getPersonById(id);
    }

    @GetMapping(value ="/getbyname/{name}")
    public List<PersonaDTOoutput> getPersonByName(@PathVariable String name) throws Exception {
        return personService.getPersonsByName(name);
    }

    @GetMapping(value ="/getall")
    public List<PersonaDTOoutput> getAllPersons() throws Exception {
        System.out.println("/getall");
        return personService.getAll();
    }

    @PostMapping(value = "/addperson")
    public PersonaDTOoutput addPersona(@RequestBody PersonaDTOinput pers) throws Exception {
        return personService.addPerson(pers);
    }


    @PutMapping("/update/id/{id}")
    public PersonaDTOoutput update(@PathVariable long id, @RequestBody PersonaDTOinput persona) throws Exception {
        return personService.updatePersonById(id, persona);
    }

    @DeleteMapping("/delete/{id}")
    public List<PersonaDTOoutput> deleteById(@PathVariable long id)throws Exception{
        return personService.deleteById(id);
    }
}
