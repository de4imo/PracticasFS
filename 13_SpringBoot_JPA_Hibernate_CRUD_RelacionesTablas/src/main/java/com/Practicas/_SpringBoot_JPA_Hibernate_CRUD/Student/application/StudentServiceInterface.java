package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.input.StudentDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output.StudentDTOoutputSimple;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;

import java.util.List;

public interface StudentServiceInterface {
    //GET
   // StudentDTOoutputSimple getStudentById(String id, String type) throws Exception;
    Object getStudentById(String id, String type) throws Exception;


    //Con este método evito repetir código
    List<StudentDTOoutputSimple> toListDTOoutput(List<Student> students);

    List<StudentDTOoutputSimple> getStudentsByName(String name) throws Exception;
    List<StudentDTOoutputSimple> getAllStudents() throws Exception;

    //POST
    StudentDTOoutputSimple addStudent(StudentDTOinput studentDTOinput) throws Exception;

    //PUT
    StudentDTOoutputSimple updateStudent(StudentDTOinput studentDTOinput, String id) throws Exception;

    //DELETE
    void deleteStudent(String id) throws Exception;
}
