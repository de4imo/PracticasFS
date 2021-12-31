package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.application.dto.output.Estudiante_AsignaturaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//OUTPUT SIMPLE SIN DATOS DE Persona
public class StudentDTOoutput {
    private String id_student;

    private String id_persona;

    private int num_hours_week;

    private String comments;

    private String id_profesor;

    private String branch;

    private List<Estudiante_AsignaturaDTOoutput> asignaturas;

    public StudentDTOoutput(Student student){

        this.asignaturas = new ArrayList();

        this.id_persona = student.getPersona().getId();
        this.id_student = student.getId_student();
        this.num_hours_week = student.getNum_hours_week();
        this.comments = student.getComments();
        //this.id_profesor = student.getId_profesor();
        this.branch = student.getBranch();

        for(Estudiante_Asignatura a: student.getAsignaturas()){

            this.asignaturas.add(new Estudiante_AsignaturaDTOoutput(a));
        }
    }
}
