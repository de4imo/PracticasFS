package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.output.ProfesorDTOoutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


//EJERCICIO 14 (RestController & Feign:)
@RestController
public class ProfControllerRestTemplate {

    @Autowired
    ProfesorFeignI profesorFeignI;

    @GetMapping("/profesor/{id}")
    ResponseEntity<ProfesorDTOoutput> getProfesorRestTemplate(@PathVariable String id)throws Exception{

        System.out.println("en ProfControllerRestTemplate, recibo id: "+id);
        ResponseEntity<ProfesorDTOoutput> responseEntity= new RestTemplate().getForEntity("http://localhost:8080/getprofesorbyid/" + id, ProfesorDTOoutput.class);

        //return ResponseEntity.ok(responseEntity.getBody());
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return responseEntity;
        }

        throw new RuntimeException("error del servidor");
    }

}
