package _SpringBootInyeccionDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador1 {

    /*Siempre se hacen @Autowired de Interfaces, no de las clases que las implementan.
    SPRING se encarga de buscar que clases utilizan esa interfaz, por lo que ahora no hay
    problema ya que solo hay una clase que la implementa, pero más adelante hay que usar @Qualifier("nombre aquí")
    si hay varias clases que lo implementan.*/
    @Autowired
    PersonService personService;

    @GetMapping(value = "/controlador1/addPersona")
    public void setPersona(@RequestParam(value = "name", defaultValue = "Sin nombre") String name,
                           @RequestParam(value = "city", defaultValue = "Sin ciudad") String city,
                           @RequestParam(value = "age"/*, defaultValue = "Sin edad"*/) Integer age){

        personService.setPerson(new Person(name, city, age));
    }

    
    @PostMapping("/controlador1/addCiudad")
    @ResponseBody
    public void addOneCity(@RequestBody City city){
        personService.getCities().add(city);
    }
}