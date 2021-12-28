package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.input;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain.Profesor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfesorDTOinput {
    private String id_persona;

    private String comments;

    private String branch;

    public Profesor toEntity(){
        Profesor profesor = new Profesor();
        //profesor.setPersona();
        profesor.setComments(comments);
        profesor.setBranch(branch);
        return profesor;
    }
}
