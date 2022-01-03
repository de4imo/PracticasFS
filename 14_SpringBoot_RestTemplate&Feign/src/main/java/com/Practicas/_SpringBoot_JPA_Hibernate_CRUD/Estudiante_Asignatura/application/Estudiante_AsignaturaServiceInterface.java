package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.application;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.application.dto.input.Estudiante_AsignaturaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.application.dto.output.Estudiante_AsignaturaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.domain.Estudiante_Asignatura;

import java.util.List;

public interface Estudiante_AsignaturaServiceInterface {
    //GET
    Estudiante_AsignaturaDTOoutput getAsignaturaById(String id) throws Exception;;

    //Con este método evito repetir código en getPersonsByName y getAllPersons
    List<Estudiante_AsignaturaDTOoutput> toListDTOoutput(List<Estudiante_Asignatura> estudianteAsignaturas);

    List<Estudiante_AsignaturaDTOoutput> getAsignaturaByName(String name) throws Exception;;
    List<Estudiante_AsignaturaDTOoutput> getAllAsignaturas();
    //List<PersonaDTOoutput> toListDTOoutput(List<Persona> personas) throws Exception;;

    //POST
    Estudiante_AsignaturaDTOoutput addAsignatura(Estudiante_AsignaturaDTOinput estudianteAsignaturaDTOinput) throws Exception;;

    //PUT
    Estudiante_AsignaturaDTOoutput updateAsignatura(Estudiante_AsignaturaDTOinput estudianteAsignaturaDTOinput, String id) throws Exception;

    //DELETE
    void deleteAsignatura(String id) throws Exception;
}
