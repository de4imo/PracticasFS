package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.output;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.output.ProfesorDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain.Profesor;
import lombok.*;


@Getter
@Setter
@ToString
public class PersonaDTOoutputProfesor extends PersonaDTOoutput{
    private ProfesorDTOoutput profesorDTOoutput;

    public PersonaDTOoutputProfesor(Persona persona, Profesor profesor){
        super(persona);
        this.profesorDTOoutput = new ProfesorDTOoutput(profesor);
    }




}
