package _SpringBootInyeccionDependencias;

import org.springframework.web.bind.annotation.*;

@RestController
public class Prueba {

    @GetMapping("/HolaMundo")
    public String getHola()
    {
        return "Hola Mundo";
    }

 /*   @GetMapping("/AdiosMundo")
    public String getAdios()
    {
        return "Adiós Mundo";
    }

    @GetMapping("/user")
    public String getGreeetingWithName(@RequestParam(value = "name", defaultValue = "Mundo!") String name) {
        return "Hola " + name;
    }

    //Muy genérico el Map<>, si en nuestra clase persona los campos se llaman exactamente igual que en el JSON
    //recibido podemos recibir a este como un objeto persona (de hecho pasa la edad de texto a Integer)
    @RequestMapping(
            value = "/useradd"),
            method = RequestMethod.POST)
    public Persona requestPostUser(@RequestBody Persona persona) {

        persona.setEdad(persona.getEdad()+1);
        return persona;
    }*/


    /*
    @RequestMapping(
            value = "/useradd"),
            method = RequestMethod.POST)
    public Persona requestPostUser(@RequestBody Map<String, Object> payload) {

        ArrayList<String> datosPersona = new ArrayList();

        payload.forEach((key, value) -> datosPersona.add(value.toString()));

        Persona p = new Persona(datosPersona.get(0), Integer.parseInt(datosPersona.get(1)), datosPersona.get(2));

        p.setEdad(p.getEdad()+1);
        return p;
    }*/
}