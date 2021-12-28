package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.input;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class StudentDTOinput {
    //String id_student;

    Persona persona;

    int num_hours_week;

    String comments;

    String id_profesor;

    String branch;

    public Student toEntity(){
        Student student = new Student();

  //    student.setId_student(id_student);

        student.setComments(comments);
        student.setNum_hours_week(num_hours_week);
  //    student.setPersona(persona);
        student.setId_profesor(id_profesor);
        student.setBranch(branch);

        return student;
    }
}
