package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.input;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.input.PersonaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.PersonaRepositorio;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StudentDTOinput {
   // String id_student;

    PersonaDTOinput personaDTOinput;

    int num_hours_week;

    String comments;

    //String id_profesor;

    String branch;


    public Student toEntity(){

        Student student = new Student();

   //     student.setId_student(id_student);

        student.setComments(comments);
        student.setNum_hours_week(num_hours_week);

     student.setPersona(personaDTOinput.toEntity());
   //     student.setId_profesor(id_profesor);
        student.setBranch(branch);

        return student;
    }

    @Override
    public String toString() {
        return "StudentDTOinput{" +
                "personaDTOinput=" + personaDTOinput +
                ", num_hours_week=" + num_hours_week +
                ", comments='" + comments + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
