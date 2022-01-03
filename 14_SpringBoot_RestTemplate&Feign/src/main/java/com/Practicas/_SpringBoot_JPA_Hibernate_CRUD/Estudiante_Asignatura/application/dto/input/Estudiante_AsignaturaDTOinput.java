package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.application.dto.input;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.input.StudentDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Estudiante_AsignaturaDTOinput {
    //private StudentDTOinput studentDTOinput;
    private String name;
    private String comments;
    private Date initial_date;
    private Date finish_date;

    public Estudiante_Asignatura toEntity(){
        Estudiante_Asignatura estudianteAsignatura = new Estudiante_Asignatura();
        //estudianteAsignatura.setStudent_asig(studentDTOinput.toEntity());
        estudianteAsignatura.setName(name);
        estudianteAsignatura.setComments(comments);
        estudianteAsignatura.setInitial_date(initial_date);
        estudianteAsignatura.setFinish_date(finish_date);

        return estudianteAsignatura;
    }
}
