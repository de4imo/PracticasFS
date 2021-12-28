package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.input.PersonaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.output.PersonaDTOoutput;

import java.util.List;

public interface PersonaServiceInterface {
    //GET
    PersonaDTOoutput getPersonById(String id) throws Exception;

    //Con este método evito repetir código en getPersonsByName y getAllPersons
    List<PersonaDTOoutput> toListDTOoutput(List<Persona> personas);

    List<PersonaDTOoutput> getPersonsByName(String name) throws Exception;
    List<PersonaDTOoutput> getAllPersons() throws Exception;

    //POST
    PersonaDTOoutput addPerson(PersonaDTOinput pers) throws Exception;

    //PUT
    PersonaDTOoutput updatePersona(PersonaDTOinput personaDTO, String id) throws Exception;

    //DELETE
    void deletePersona(String id) throws Exception;
}
