package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.output;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output.StudentDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import lombok.*;

@Getter
@Setter
@ToString
public class PersonaDTOoutputEstudiante extends PersonaDTOoutput{
    private StudentDTOoutput studentDTOoutput;

    public PersonaDTOoutputEstudiante(Persona persona, Student student){
        super(persona);
        this.studentDTOoutput = new StudentDTOoutput(student);
    }


    /*public PersonaDTOoutputEstudiante(Persona persona, Student student){
        super(persona);
        this.student = student;
    }*/
}
