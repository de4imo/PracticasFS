package com.Practicas._SpringBoot_CRUD_Records.application;

import com.Practicas._SpringBoot_CRUD_Records.application.DTOs.PersonaDTOinput;
import com.Practicas._SpringBoot_CRUD_Records.application.DTOs.PersonaDTOoutput;
import com.Practicas._SpringBoot_CRUD_Records.application.common.NotFoundException;
import com.Practicas._SpringBoot_CRUD_Records.application.common.UnprocesableException;
import com.Practicas._SpringBoot_CRUD_Records.domain.Person;
import com.Practicas._SpringBoot_CRUD_Records.domain.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class PersonService implements PersonServiceInterface{

    @Autowired
    PersonRepository personaRepository;

    @Override
    public PersonaDTOoutput addPerson(PersonaDTOinput personaDTOinput) throws Exception {
        isValid(personaDTOinput);

        Person person = new Person(personaDTOinput);

        personaRepository.saveAndFlush(person);

        return person.toPersonaDTOoutput();
    }

    @Override
    public List<PersonaDTOoutput> getPersonsByName(String name) throws Exception {
        if(name.isEmpty()){throw  new UnprocesableException ("No ha introducido un nombre");}

        List <Person> persons = personaRepository.findByName(name);
        if(persons.isEmpty()){throw  new NotFoundException ("No hay personas con nombre '" + name + "'.");}


        return toListDTOoutput(persons);
    }

    private List<PersonaDTOoutput> toListDTOoutput(List <Person> persons) throws Exception {
        List<PersonaDTOoutput> personsDTO = new ArrayList();

        for(Person p: persons){ personsDTO.add(p.toPersonaDTOoutput()); }
        return personsDTO;
    }

    @Override
    public List<PersonaDTOoutput> getAll() throws Exception {
        List <Person> persons = personaRepository.findAll();
        if(persons.isEmpty()){throw new NotFoundException ("No hay personas.");}

        return toListDTOoutput(persons);
    }

    @Override
    public PersonaDTOoutput getPersonById(long id) throws Exception {
        Person person = personaRepository.findById(id).orElseThrow(()-> new NotFoundException("No existe persona con id: " + id));

        return person.toPersonaDTOoutput();
    }

    @Override
    public PersonaDTOoutput updatePersonById(long id, PersonaDTOinput personaDTOinput) throws Exception {
        Person person = personaRepository.findById(id).orElseThrow(()-> new NotFoundException("No existe persona con id: " + id));
        isValid(personaDTOinput);

        Person personNew = new Person(personaDTOinput);
        personNew.setId(id);
        personaRepository.saveAndFlush(personNew);

        return personNew.toPersonaDTOoutput();
    }

    @Override
    public List<PersonaDTOoutput> deleteById(long id) throws Exception {
        Person person = personaRepository.findById(id).orElseThrow(()-> new NotFoundException("No existe persona con id: " + id));

        personaRepository.deleteById(id);

        return getAll();
    }

    public boolean isValid(PersonaDTOinput personaDTOinput) throws Exception {
        if(personaDTOinput.name() == null ){throw new UnprocesableException("El campo name est?? vac??o.");}
        if(personaDTOinput.name().length()<5){throw new UnprocesableException("El campo name tiene menos de 5 car??cteres.");}
        if(personaDTOinput.usuario() == null){throw new UnprocesableException("El campo usuario est?? vac??o.");}
        if(personaDTOinput.password() == null){throw new UnprocesableException("El campo password est?? vac??o.");}
        if(personaDTOinput.surname() == null){throw new UnprocesableException("El campo surname est?? vac??o.");}
        if(personaDTOinput.company_email() == null){throw new UnprocesableException("El campo company_email est?? vac??o.");}
        if(personaDTOinput.personal_email() == null){throw new UnprocesableException("El campo personal_email est?? vac??o.");}
        if(personaDTOinput.city() == null){throw new UnprocesableException("El campo city est?? vac??o.");}
        if(personaDTOinput.created_date() == null){throw new UnprocesableException("El campo created_date est?? vac??o.");}
        return true;
    }


    public static final String GREATER_THAN="greater";
    public static final String LESS_THAN="less";
    public static final String EQUAL="equal";

    @Override
    public List<PersonaDTOoutput> getByCriteria(String user, String name, String surname, Date createdDate, String dateCondition, int pageNumber) throws Exception{
        HashMap<String, Object> data = new HashMap<>();

        if (user!=null)
            data.put("id",user);
        if (name!=null)
            data.put("name",name);
        if (surname!=null)
            data.put("surname",surname);
        if (dateCondition==null)
            dateCondition=GREATER_THAN;
        if (createdDate!=null) {
            data.put("created_date",createdDate);
            data.put("dateCondition",dateCondition);
        }
        if (!dateCondition.equals(GREATER_THAN) && !dateCondition.equals(LESS_THAN) && !dateCondition.equals(EQUAL))
            dateCondition=GREATER_THAN;


        //Pageable aqu?? es prescindible, se podr??an enviar dos n??meros y ya
        Pageable pageable = PageRequest.of(pageNumber, 10);

        return toListDTOoutput(personaRepository.getData(data, pageable));
    }

}
