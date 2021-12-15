package _SpringBootInyeccionDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador1 {

    @Autowired //Siempre se hacen de Interfaces, no de las clases que las implementan
    PersonService personService;

    @GetMapping(value = "/controlador1/addPersona")
    public void setPersona(@RequestParam(value = "name", defaultValue = "Sin nombre") String name,
                           @RequestParam(value = "city", defaultValue = "Sin ciudad") String city,
                           @RequestParam(value = "age", defaultValue = "Sin edad") Integer age){

        personService.setPerson(new Person(name, city, age));
        System.out.println("Set persona, edad: " + personService.getPerson().getAge());
    }
}
