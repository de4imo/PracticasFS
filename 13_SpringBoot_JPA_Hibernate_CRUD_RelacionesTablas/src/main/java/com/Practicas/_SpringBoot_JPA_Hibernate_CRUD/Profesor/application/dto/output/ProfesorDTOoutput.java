package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.output;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain.Profesor;

public class ProfesorDTOoutput {
    private String id_persona;

    private String comments;

    private String branch;

    public ProfesorDTOoutput(Profesor profesor){
        this.id_persona = profesor.getPersona().getId();
        this.comments = profesor.getComments();
        this.branch = profesor.getBranch();
    }
}
