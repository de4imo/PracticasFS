package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.output.PersonaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import lombok.Data;

@Data
public class StudentDTOoutputFull{
    String id_student;

//    Persona persona;
    PersonaDTOoutput personaDTOoutput;

    int num_hours_week;

    String comments;

    //String id_profesor;

    String branch;

    public StudentDTOoutputFull(Student student){
        System.out.println("Hola desde: public StudentDTOoutputFull(Student student){...");
        this.id_student = student.getId_student();
//        this.persona = student.getPersona();
        this.personaDTOoutput = new PersonaDTOoutput(student.getPersona());
        this.num_hours_week = student.getNum_hours_week();
        this.comments = student.getComments();
        //this.id_profesor = student.getId_profesor();
        this.branch = student.getBranch();
    }
}
