package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.application.dto.output;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output.StudentDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Estudiante_AsignaturaDTOoutput {

    String id_asignatura;
   // private Student student;
    private String name;
    private String comments;
    private Date initial_date;
    private Date finish_date;

   // private List <StudentDTOoutput> estudiantes;

    //private StudentDTOoutput studentDTOoutput;

    public Estudiante_AsignaturaDTOoutput(Estudiante_Asignatura estudianteAsignatura){
        this.id_asignatura = estudianteAsignatura.getId();
        //this.student = estudianteAsignatura.getStudent_asig();
        this.name = estudianteAsignatura.getName();
        this.comments = estudianteAsignatura.getComments();
        this.initial_date = estudianteAsignatura.getInitial_date();
        this.finish_date = estudianteAsignatura.getFinish_date();

        //studentDTOoutput = new StudentDTOoutput(estudianteAsignatura.getStudent());
    }
}
