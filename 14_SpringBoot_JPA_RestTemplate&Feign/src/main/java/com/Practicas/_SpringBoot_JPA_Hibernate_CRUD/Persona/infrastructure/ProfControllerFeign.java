package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.output.ProfesorDTOoutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//EJERCICIO 14 (RestController & Feign:)
@RestController
public class ProfControllerFeign {

    @Autowired
    ProfesorFeignI profesorFeignI;

    @GetMapping("/persona/profesor/{id}")
    ResponseEntity<ProfesorDTOoutput> getProfesorFeign(@PathVariable String id) throws  Exception{

        return profesorFeignI.getProfesorExterno(id);
    }
}
