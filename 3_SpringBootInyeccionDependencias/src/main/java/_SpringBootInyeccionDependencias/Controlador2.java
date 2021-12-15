package _SpringBootInyeccionDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {

    @Autowired //Siempre se hacen de Interfaces, no de las clases que las implementan
    PersonService personService;

    @GetMapping(value = "/controlador2/getPersona")
    public Person getPersona(){
        Person per = personService.getPerson();
        Integer edadDoble = per.getAge()*2;

        per.setAge(edadDoble);
        return per;
    }
}