package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.input.StudentDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output.StudentDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;

import java.util.List;

public interface StudentServiceInterface {
    //GET
    StudentDTOoutput getStudentById(String id) throws Exception;

    //Con este método evito repetir código
    List<StudentDTOoutput> toListDTOoutput(List<Student> students);

    List<StudentDTOoutput> getStudentsByName(String name) throws Exception;
    List<StudentDTOoutput> getAllStudents() throws Exception;

    //POST
    StudentDTOoutput addStudent(StudentDTOinput studentDTOinput) throws Exception;

    //PUT
    StudentDTOoutput updateStudent(StudentDTOinput studentDTOinput, String id) throws Exception;

    //DELETE
    void deleteStudent(String id) throws Exception;
}
