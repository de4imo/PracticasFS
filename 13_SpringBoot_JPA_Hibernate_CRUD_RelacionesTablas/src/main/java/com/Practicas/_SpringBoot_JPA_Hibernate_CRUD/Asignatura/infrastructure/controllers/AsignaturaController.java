package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.infrastructure.controllers;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.application.AsignaturaServiceInterface;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.application.dto.input.AsignaturaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.application.dto.output.AsignaturaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.CustomError;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.NotFoundException;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AsignaturaController {

    @Autowired
    AsignaturaServiceInterface asignaturaServiceInterface;

    //GET
    @GetMapping(value ="/getasignaturabyid/{id}")
    public AsignaturaDTOoutput getAsignaturaById(@PathVariable String id) throws Exception {
        return asignaturaServiceInterface.getAsignaturaById(id);
    }

    @GetMapping(value ="/getasignaturabyname/{name}")
    public List<AsignaturaDTOoutput> getAsignaturaByName(@PathVariable String name) throws Exception {
        return asignaturaServiceInterface.getAsignaturaByName(name);
    }

    @GetMapping(value ="/getallasignaturas")
    public List<AsignaturaDTOoutput> getAllAsignaturas() throws Exception {
        return asignaturaServiceInterface.getAllAsignaturas();
    }

    //POST
    @PostMapping(value = "/addasignatura")
    public AsignaturaDTOoutput addAsignatura(@RequestBody AsignaturaDTOinput asignaturaDTOinput) throws Exception {
        return asignaturaServiceInterface.addAsignatura(asignaturaDTOinput);
    }

    //PUT
    @PutMapping("/updateasignatura/id/{id}")
    public ResponseEntity<?> updateAsignatura(@RequestBody AsignaturaDTOinput asignaturaDTOinput, @PathVariable("id") String id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(asignaturaServiceInterface.updateAsignatura(asignaturaDTOinput, id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error del servidor");
        }
    }

    //DELETE
    @DeleteMapping("/deleteasignatura/{id}")
    public ResponseEntity<?> deleteAsignatura(@PathVariable("id") String id) throws Exception {
        try {
            asignaturaServiceInterface.deleteAsignatura(id);
            return ResponseEntity.status(HttpStatus.OK).body("Asignatura borrada con exito.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error del servidor");

        }
    }

    @ResponseBody
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
    }

}
