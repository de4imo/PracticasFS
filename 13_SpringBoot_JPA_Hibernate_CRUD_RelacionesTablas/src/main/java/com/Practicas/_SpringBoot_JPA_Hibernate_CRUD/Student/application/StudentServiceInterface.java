package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.input.StudentDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output.StudentDTOoutputFull;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;

import java.util.List;

public interface StudentServiceInterface {
    //GET
   // StudentDTOoutputFull getStudentById(String id, String type) throws Exception;
    Object getStudentById(String id, String type) throws Exception;


    //Con este método evito repetir código
    List<StudentDTOoutputFull> toListDTOoutput(List<Student> students);

    List<StudentDTOoutputFull> getStudentsByName(String name) throws Exception;
    List<StudentDTOoutputFull> getAllStudents() throws Exception;

    //POST
    StudentDTOoutputFull addStudent(StudentDTOinput studentDTOinput) throws Exception;

    //PUT
    StudentDTOoutputFull updateStudent(StudentDTOinput studentDTOinput, String id) throws Exception;

    //DELETE
    void deleteStudent(String id) throws Exception;
}
