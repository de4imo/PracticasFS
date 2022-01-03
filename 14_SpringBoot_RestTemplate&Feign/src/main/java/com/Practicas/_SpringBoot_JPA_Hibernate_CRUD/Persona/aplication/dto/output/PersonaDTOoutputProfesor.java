package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.output;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.output.ProfesorDTOoutput;
import lombok.*;


@Getter
@Setter
@ToString
public class PersonaDTOoutputProfesor extends PersonaDTOoutput{
    private ProfesorDTOoutput profesorDTOoutput;

    public PersonaDTOoutputProfesor(Persona persona){//}, Profesor profesor){
        super(persona);

        try{ this.profesorDTOoutput = new ProfesorDTOoutput(persona.getProfesor());
        }catch (Exception e){ this.profesorDTOoutput = null;}

        //this.profesorDTOoutput = new ProfesorDTOoutput(profesor);
    }
}
