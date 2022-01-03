package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.output.ProfesorDTOoutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Name para indicar el servicio externo que vamos a usar, ahora no lo estamos usando realmente
@FeignClient(name = "feignTest", url = "http://localhost:8081")
public interface ProfesorFeignI {


    @GetMapping("/profesor/{id}")
    public ResponseEntity<ProfesorDTOoutput> getProfesorExterno(@PathVariable String id) throws Exception;
}
