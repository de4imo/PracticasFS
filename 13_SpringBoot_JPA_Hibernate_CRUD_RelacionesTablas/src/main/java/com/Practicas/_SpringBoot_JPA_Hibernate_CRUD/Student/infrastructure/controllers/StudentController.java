package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.infrastructure.controllers;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.input.StudentDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output.StudentDTOoutputFull;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentServiceInterface studentServiceInterface;


    //GET
/*    @GetMapping(value ="/getstudentbyid/{id}")
    public StudentDTOoutput getStudentById(@PathVariable String id) throws Exception {
        return studentServiceInterface.getStudentById(id);
    }
*/
    //http://localhost:8080/{id}?outputType=full
  /*  @GetMapping(value ="getstudentbyid/{id}")//, params = "outputType")
    public StudentDTOoutputFull getStudentById(@PathVariable String id, @RequestParam(value = "outputType", defaultValue = "simple") String typeOfValue) throws Exception {
        return studentServiceInterface.getStudentById(id, typeOfValue);
    }*/


    @GetMapping(value ="/getstudentbyid/{id}")//, params = "outputType")
    public Object getStudentById(@PathVariable String id, @RequestParam(value = "outputType", defaultValue = "simple") String typeOfValue) throws Exception {
        return studentServiceInterface.getStudentById(id, typeOfValue);
    }


    @GetMapping(value ="/getstudentbyname/{name}")
    public List<StudentDTOoutputFull> getStudentByName(@PathVariable String name) throws Exception {
        return studentServiceInterface.getStudentsByName(name);
    }

    @GetMapping(value ="/getallStudents")
    public List<StudentDTOoutputFull> getAllStudents() throws Exception {
        return studentServiceInterface.getAllStudents();
    }

    //POST
    @PostMapping(value = "/addStudent")
    public StudentDTOoutputFull addStudent(@RequestBody StudentDTOinput studentDTOinput) throws Exception {
        return studentServiceInterface.addStudent(studentDTOinput);
    }

    //PUT
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTOinput studentDTOinput, @PathVariable("id") String id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentServiceInterface.updateStudent(studentDTOinput, id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error del servidor");
        }
    }

    //DELETE
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") String id) throws Exception {
        try {
            studentServiceInterface.deleteStudent(id);
            return ResponseEntity.status(HttpStatus.OK).body("Student borrado con exito");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error del servidor");
        }
    }
}