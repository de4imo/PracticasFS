package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure.controllers.dto.input.PersonaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure.controllers.dto.output.PersonaDTOoutput;

import java.util.List;

public interface PersonaServiceInterface {
    //GET
    PersonaDTOoutput getPersonById(long id) throws Exception;
    List<PersonaDTOoutput> getPersonsByName(String name) throws Exception;
    List<PersonaDTOoutput> getAllPersons() throws Exception;

    //POST
    PersonaDTOoutput addPerson(PersonaDTOinput pers) throws Exception;

    //PUT
    PersonaDTOoutput updatePersona(PersonaDTOinput personaDTO, long id) throws Exception;

    //DELETE
    void deletePersona(long id) throws Exception;
}
