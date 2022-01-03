package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.input.PersonaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.output.PersonaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.input.ProfesorDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.output.ProfesorDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain.Profesor;

import java.util.List;

public interface ProfesorServiceInterface {
    //GET
    ProfesorDTOoutput getProfesorById(String id) throws Exception;

    //Con este método evito repetir código
    List<ProfesorDTOoutput> toListDTOoutput(List<Profesor> profesores);

    List<ProfesorDTOoutput> getProfesoresByName(String name) throws Exception;

    List<ProfesorDTOoutput> getAllProfesores() throws Exception;

    //POST
    ProfesorDTOoutput addProfesor(ProfesorDTOinput profesorDTOinput) throws Exception;

    //PUT
    ProfesorDTOoutput updateProfesor(ProfesorDTOinput profesorDTOinput, String id) throws Exception;

    //DELETE
    void deleteProfesor(String id) throws Exception;
}
