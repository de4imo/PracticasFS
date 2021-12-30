package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.input;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.input.PersonaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain.Profesor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class ProfesorDTOinput {
    //private String id_persona;

    private PersonaDTOinput personaDTOinput;

    private String comments;

    private String branch;

    public Profesor toEntity(){
        Profesor profesor = new Profesor();
        profesor.setPersonaProf(personaDTOinput.toEntity());
        profesor.setComments(comments);
        profesor.setBranch(branch);
        return profesor;
    }

    @Override
    public String toString() {
        return "ProfesorDTOinput{" +
                "personaDTOinput=" + personaDTOinput +
                ", comments='" + comments + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
