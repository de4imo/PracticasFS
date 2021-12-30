package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//OUTPUT SIMPLE SIN DATOS DE Persona
public class StudentDTOoutput {
    String id_student;

    private String id_persona;

    int num_hours_week;

    String comments;

    //String id_profesor;

    String branch;

    public StudentDTOoutput(Student student){
        this.id_persona = student.getPersona().getId();
        this.id_student = student.getId_student();
        this.num_hours_week = student.getNum_hours_week();
        this.comments = student.getComments();
        //this.id_profesor = student.getId_profesor();
        this.branch = student.getBranch();
    }




}
