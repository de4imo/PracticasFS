package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.application.dto.input;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.domain.Asignatura;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class AsignaturaDTOinput {
    private Student student;
    private String name;
    private String comments;
    private Date initial_date;
    private Date finish_date;


    public Asignatura toEntity(){
        Asignatura asignatura = new Asignatura();

        asignatura.setStudent(student);
        asignatura.setName(name);
        asignatura.setComments(comments);
        asignatura.setInitial_date(initial_date);
        asignatura.setFinish_date(finish_date);

        return asignatura;
    }

}
