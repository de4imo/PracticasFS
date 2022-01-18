package com.Practicas._SpringBoot_CRUD_Records.application;

import com.Practicas._SpringBoot_CRUD_Records.application.DTOs.PersonaDTOinput;
import com.Practicas._SpringBoot_CRUD_Records.application.DTOs.PersonaDTOoutput;

import java.util.Date;
import java.util.List;

public interface PersonServiceInterface {

    PersonaDTOoutput addPerson(PersonaDTOinput personaDTOinput)throws Exception;

    List<PersonaDTOoutput> getPersonsByName(String name)throws Exception;

    List<PersonaDTOoutput> getAll()throws Exception;

    PersonaDTOoutput getPersonById(long id)throws Exception;

    PersonaDTOoutput updatePersonById(long id, PersonaDTOinput personaDTOinput)throws Exception;

    List<PersonaDTOoutput> deleteById(long id)throws Exception;

    List<PersonaDTOoutput> getByCriteria(String user, String name, String surname, Date createdDate, String dateCondition, int page)throws Exception;

}
