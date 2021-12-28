package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.infrastructure.controllers;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.ProfesorServiceInterface;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.input.ProfesorDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.output.ProfesorDTOoutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfesorController {

        @Autowired
        ProfesorServiceInterface profesorServiceInterface;


        //GET
        @GetMapping(value = "/getProfesorbyid/{id}")
        public ProfesorDTOoutput getProfesorById (@PathVariable String id) throws Exception {
        return profesorServiceInterface.getProfesorById(id);
    }

        @GetMapping(value = "/getProfesorbyname/{name}")
        public List<ProfesorDTOoutput> getProfesoresByName (@PathVariable String name) throws Exception {
        return profesorServiceInterface.getProfesoresByName(name);
    }

        @GetMapping(value = "/getallProfesors")
        public List<ProfesorDTOoutput> getAllProfesors () throws Exception {
        return profesorServiceInterface.getAllProfesores();
    }

        //POST
        @PostMapping(value = "/addProfesor")
        public ProfesorDTOoutput addProfesor (@RequestBody ProfesorDTOinput profesorDTOinput) throws Exception {
        return profesorServiceInterface.addProfesor(profesorDTOinput);
    }

        //PUT
        @PutMapping("/updateProfesor/id/{id}")
        public ResponseEntity<?> updateProfesor (@RequestBody ProfesorDTOinput
        profesorDTOinput, @PathVariable("id") String id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(profesorServiceInterface.updateProfesor(profesorDTOinput, id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error del servidor");
        }
    }

        //DELETE
        @DeleteMapping("/deleteProfesor/{id}")
        public ResponseEntity<?> deleteProfesor (@PathVariable("id") String id) throws Exception {
        try {
            profesorServiceInterface.deleteProfesor(id);
            return ResponseEntity.status(HttpStatus.OK).body("Profesor borrado con exito.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error del servidor.");

        }
    }

}
