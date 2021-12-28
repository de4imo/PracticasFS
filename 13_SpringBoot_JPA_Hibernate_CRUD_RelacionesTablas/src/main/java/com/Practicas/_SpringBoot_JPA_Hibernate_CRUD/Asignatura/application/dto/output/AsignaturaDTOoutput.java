package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.application.dto.output;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.domain.Asignatura;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class AsignaturaDTOoutput {

   // String id_asignatura;
    private Student student;
    private String name;
    private String comments;
    private Date initial_date;
    private Date finish_date;


    public AsignaturaDTOoutput(Asignatura asignatura){
        this.student = asignatura.getStudent();
        this.name = asignatura.getName();
        this.comments = asignatura.getComments();
        this.initial_date = asignatura.getInitial_date();
        this.finish_date = asignatura.getFinish_date();
    }
}
