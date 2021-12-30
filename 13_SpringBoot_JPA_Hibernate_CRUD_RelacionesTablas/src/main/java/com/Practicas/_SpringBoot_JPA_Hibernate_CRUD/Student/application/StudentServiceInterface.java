package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.input.StudentDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output.StudentDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;

import java.util.List;

public interface StudentServiceInterface {
    //GET
   // StudentDTOoutputSimple getStudentById(String id, String type) throws Exception;
    StudentDTOoutput getStudentById(String id, String type) throws Exception;


    //Con este método evito repetir código
    List<StudentDTOoutput> toListDTOoutput(List<Student> students);

    List<StudentDTOoutput> getStudentsByName(String name) throws Exception;
    List<StudentDTOoutput> getAllStudents() throws Exception;

    //POST
    StudentDTOoutput addStudent(StudentDTOinput studentDTOinput) throws Exception;

    //PUT
    StudentDTOoutput updateStudent(StudentDTOinput studentDTOinput, String id) throws Exception;

    StudentDTOoutput addAsignaturaToStudent(String id_estud, String id_student_asig) throws Exception;

    //DELETE
    void deleteStudent(String id) throws Exception;
}
