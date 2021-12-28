package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.application;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.application.dto.input.AsignaturaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.application.dto.output.AsignaturaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.domain.Asignatura;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.output.PersonaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;

import java.util.List;

public interface AsignaturaServiceInterface {
    //GET
    AsignaturaDTOoutput getAsignaturaById(String id) throws Exception;;

    //Con este método evito repetir código en getPersonsByName y getAllPersons
    List<AsignaturaDTOoutput> toListDTOoutput(List<Asignatura> asignaturas);

    List<AsignaturaDTOoutput> getAsignaturaByName(String name) throws Exception;;
    List<AsignaturaDTOoutput> getAllAsignaturas();
    //List<PersonaDTOoutput> toListDTOoutput(List<Persona> personas) throws Exception;;

    //POST
    AsignaturaDTOoutput addAsignatura(AsignaturaDTOinput asignaturaDTOinput) throws Exception;;

    //PUT
    AsignaturaDTOoutput updateAsignatura(AsignaturaDTOinput asignaturaDTOinput, String id) throws Exception;

    //DELETE
    void deleteAsignatura(String id) throws Exception;
}
