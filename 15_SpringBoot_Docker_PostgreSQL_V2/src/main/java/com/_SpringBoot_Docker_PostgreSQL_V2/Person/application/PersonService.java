package com._SpringBoot_Docker_PostgreSQL_V2.Person.application;

import com._SpringBoot_Docker_PostgreSQL_V2.Person.application.DTOs.PersonDTOinput;
import com._SpringBoot_Docker_PostgreSQL_V2.Person.application.DTOs.PersonDTOoutput;
import com._SpringBoot_Docker_PostgreSQL_V2.Person.domain.Person;
import com._SpringBoot_Docker_PostgreSQL_V2.Person.domain.PersonRepository;
import com._SpringBoot_Docker_PostgreSQL_V2.common.NotFoundException;
import com._SpringBoot_Docker_PostgreSQL_V2.common.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements PersonServiceInterface{

    @Autowired
    PersonRepository personRepository;


    //Para obtener una lista (tanto si hemos buscado por nombres o queremos la lista completa)
    @Override
    public List<PersonDTOoutput> toListDTOoutput(List<Person> personas){
        List<PersonDTOoutput> personasDTO = new ArrayList();

        for(Person p: personas){
                personasDTO.add(new PersonDTOoutput(p));
        }
        return personasDTO;
    }


    //GET
    @Override
    public PersonDTOoutput getPersonById(String id) throws Exception {
        Person persona = personRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe usuario con id:" + id));
        return new PersonDTOoutput(persona);
    }


    @Override
    public List<PersonDTOoutput> getPersonsByName(String name) throws Exception {
        if(name == null ||name.isEmpty()){ throw new UnprocesableException("El nombre que has introducido está vacío");}
        List<Person> personas = personRepository.findByName(name);
        if(personas.isEmpty()){ throw new NotFoundException("No existen personas con nombre" + name);}
        return toListDTOoutput(personas);
    }

    @Override
    public List<PersonDTOoutput> getAllPersons() throws Exception {
        List<Person> personas = personRepository.findAll();
        if(personas.isEmpty()){ throw  new NotFoundException("La base de datos de personas está vacía.");}
        return toListDTOoutput(personas);
    }



    //POST
    @Override
    public PersonDTOoutput addPerson(PersonDTOinput pers) throws Exception {
        if(pers == null){throw new UnprocesableException("Persona enviada es nula o está vacía.");}
        if(pers.getName().length()<6 || pers.getName().length()>10){throw new UnprocesableException("UnprocesableException: Persona enviada tiene un nombre cuya longitud no está entre 6 y 10 caracteres."); }

        Person persona = pers.toEntity();
        personRepository.saveAndFlush(persona);

        return new PersonDTOoutput(persona);
    }



    //PUT
    @Override
    public PersonDTOoutput updatePerson(PersonDTOinput personaDTOinput, String id) throws Exception {
        if(personRepository.findById(id).isEmpty()){throw new NotFoundException("No existe persona con id: " + id + ".");}
        if(personaDTOinput == null){throw new UnprocesableException("Persona enviada es nula o está vacía.");}
        if(personaDTOinput.getName().length()<6 || personaDTOinput.getName().length()>10){throw new UnprocesableException("UnprocesableException: Persona enviada tiene un nombre cuya longitud no está entre 6 y 10 caracteres.");}

        Person persona = personaDTOinput.toEntity();
        persona.setId(id);
        personRepository.saveAndFlush(persona);

        return new PersonDTOoutput(persona);
    }

    //DELETE
    @Override
    public List<PersonDTOoutput> deletePerson(String id) throws Exception {
        Person persona = personRepository.findById(id).get();
        if(personRepository.findById(id).isEmpty()){throw new NotFoundException("No existe persona con id:" + id);}

        personRepository.delete(persona);
        return getAllPersons();
    }
}
