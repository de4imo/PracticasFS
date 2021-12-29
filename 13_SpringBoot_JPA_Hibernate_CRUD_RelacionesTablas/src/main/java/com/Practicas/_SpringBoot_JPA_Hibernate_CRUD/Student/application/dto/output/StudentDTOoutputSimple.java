package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import lombok.Data;

@Data
public class StudentDTOoutputSimple {
    String id_student;

    int num_hours_week;

    String comments;

    //String id_profesor;

    String branch;

    public StudentDTOoutputSimple(Student student){
        this.id_student = student.getId_student();
        this.num_hours_week = student.getNum_hours_week();
        this.comments = student.getComments();
        //this.id_profesor = student.getId_profesor();
        this.branch = student.getBranch();
    }




}
