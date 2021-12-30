package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.output;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain.Profesor;
import lombok.Data;

@Data
public class ProfesorDTOoutput {
    private String id_persona;

    private String id_profesor;

    private String comments;

    private String branch;

    public ProfesorDTOoutput(Profesor profesor){
        this.id_persona = profesor.getPersonaProf().getId();
        this.id_profesor = profesor.getId_profesor();
        this.comments = profesor.getComments();
        this.branch = profesor.getBranch();
    }
}
