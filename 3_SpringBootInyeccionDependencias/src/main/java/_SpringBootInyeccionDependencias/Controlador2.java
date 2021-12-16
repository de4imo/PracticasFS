package _SpringBootInyeccionDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador2 {

    @Autowired //Siempre se hacen de Interfaces, no de las clases que las implementan
    PersonService personService;

    @Qualifier("bean1")
    @Autowired
    Person personBean1;

    @Qualifier("bean2")
    @Autowired
    Person personBean2;

    @Qualifier("bean3")
    @Autowired
    Person personBean3;



    @GetMapping(value = "/controlador2/getPersona")
    public Person getPersona(){
        Person per = personService.getPerson();
        Integer edadDoble = per.getAge()*2;

        per.setAge(edadDoble);
        return per;
    }

    //http://localhost:8080/controlador2/getCiudades
    @GetMapping(value = "/controlador2/getCiudades")
    public List<City> getCity(){
        return personService.getCities();
    }


    @GetMapping("controlador/bean/{bean}")
    @ResponseBody
    public Person getBeanByName(@PathVariable String bean) {
        switch (bean) {
            case "bean1": return personBean1;
            case "bean2": return personBean2;
            case "bean3": return personBean3;
            default: return null;
        }
    }
}