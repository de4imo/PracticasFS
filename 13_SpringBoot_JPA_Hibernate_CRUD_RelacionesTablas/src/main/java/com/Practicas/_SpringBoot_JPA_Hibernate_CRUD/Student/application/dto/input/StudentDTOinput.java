package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.input;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.input.PersonaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTOinput {

    private PersonaDTOinput personaDTOinput;

    private int num_hours_week;

    private String comments;

    private String branch;

    public Student toEntity(){

        Student student = new Student();
        student.setComments(comments);
        student.setNum_hours_week(num_hours_week);

        student.setPersona(personaDTOinput.toEntity());
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
