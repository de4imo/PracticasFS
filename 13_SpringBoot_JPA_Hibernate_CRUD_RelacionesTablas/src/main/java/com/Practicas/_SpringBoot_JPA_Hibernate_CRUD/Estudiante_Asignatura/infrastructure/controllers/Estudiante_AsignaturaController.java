package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.infrastructure.controllers;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.application.Estudiante_AsignaturaServiceInterface;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.application.dto.input.Estudiante_AsignaturaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.application.dto.output.Estudiante_AsignaturaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.CustomError;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.NotFoundException;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Estudiante_AsignaturaController {

    @Autowired
    Estudiante_AsignaturaServiceInterface estudianteAsignaturaServiceInterface;

    //GET
    @GetMapping(value ="/getasignaturabyid/{id}")
    public Estudiante_AsignaturaDTOoutput getAsignaturaById(@PathVariable String id) throws Exception {
        return estudianteAsignaturaServiceInterface.getAsignaturaById(id);
    }

    @GetMapping(value ="/getasignaturabyname/{name}")
    public List<Estudiante_AsignaturaDTOoutput> getAsignaturaByName(@PathVariable String name) throws Exception {
        return estudianteAsignaturaServiceInterface.getAsignaturaByName(name);
    }

    @GetMapping(value ="/getallasignaturas")
    public List<Estudiante_AsignaturaDTOoutput> getAllAsignaturas() throws Exception {
        return estudianteAsignaturaServiceInterface.getAllAsignaturas();
    }

    //POST
    @PostMapping(value = "/addasignatura")
    public Estudiante_AsignaturaDTOoutput addAsignatura(@RequestBody Estudiante_AsignaturaDTOinput estudianteAsignaturaDTOinput) throws Exception {
        return estudianteAsignaturaServiceInterface.addAsignatura(estudianteAsignaturaDTOinput);
    }

    //PUT
    @PutMapping("/updateasignatura/id/{id}")
    public ResponseEntity<?> updateAsignatura(@RequestBody Estudiante_AsignaturaDTOinput estudianteAsignaturaDTOinput, @PathVariable("id") String id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(estudianteAsignaturaServiceInterface.updateAsignatura(estudianteAsignaturaDTOinput, id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error del servidor");
        }
    }

    //DELETE
    @DeleteMapping("/deleteasignatura/{id}")
    public ResponseEntity<?> deleteAsignatura(@PathVariable("id") String id) throws Exception {
        try {
            estudianteAsignaturaServiceInterface.deleteAsignatura(id);
            return ResponseEntity.status(HttpStatus.OK).body("Asignatura borrada con exito.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error del servidor");

        }
    }

    /*@ResponseBody
    @ExceptionHandler({NotFoundException.class})
    public CustomError handleExceptionNotFound() {
        System.out.println("hola desde el exception handler en CONTROLADORES, método handleExceptionNotFound");
        CustomError customError = new CustomError();
        customError.setNotFoundException();
        return customError;
    }

    @ResponseBody
    @ExceptionHandler({UnprocesableException.class})
    public CustomError handleUnprocesableException() {
        System.out.println("hola desde el exception handler en CONTROLADORES, método handleUnprocesableException");
        CustomError customError = new CustomError();
        customError.setUnprocesableException();
        return customError;
    }*/

}
