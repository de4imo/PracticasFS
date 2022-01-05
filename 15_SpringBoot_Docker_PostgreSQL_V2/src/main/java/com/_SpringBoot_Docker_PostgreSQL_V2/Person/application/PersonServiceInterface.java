package com._SpringBoot_Docker_PostgreSQL_V2.Person.application;

import com._SpringBoot_Docker_PostgreSQL_V2.Person.application.DTOs.PersonDTOinput;
import com._SpringBoot_Docker_PostgreSQL_V2.Person.application.DTOs.PersonDTOoutput;
import com._SpringBoot_Docker_PostgreSQL_V2.Person.domain.Person;

import java.util.List;

public interface PersonServiceInterface {
    //GET
    PersonDTOoutput getPersonById(String id) throws Exception;

    //Con este método evito repetir código en getPersonsByName y getAllPersons
    List<PersonDTOoutput> toListDTOoutput(List<Person> personas);

    List<PersonDTOoutput> getPersonsByName(String name) throws Exception;
    List<PersonDTOoutput> getAllPersons() throws Exception;

    //POST
    PersonDTOoutput addPerson(PersonDTOinput personDTOinput) throws Exception;

    //PUT
    PersonDTOoutput updatePerson(PersonDTOinput personDTOinput, String id) throws Exception;

    //DELETE
    List<PersonDTOoutput> deletePerson(String id) throws Exception;
}
