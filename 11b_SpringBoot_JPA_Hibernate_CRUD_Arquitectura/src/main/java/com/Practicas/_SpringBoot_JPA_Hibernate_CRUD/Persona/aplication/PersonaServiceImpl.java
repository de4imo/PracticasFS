package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.PersonaRepositorio;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure.controllers.dto.input.PersonaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure.controllers.dto.output.PersonaDTOoutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonaServiceImpl implements  PersonaServiceInterface{
    @Autowired
    PersonaRepositorio personaRepositorio;

    //GET
    @Override
    public PersonaDTOoutput getPersonById(long id) throws Exception {
        Persona persona = personaRepositorio.findById(id).orElseThrow(() -> new NoSuchElementException("no existe usuario con id:" + id));

        PersonaDTOoutput personaDTOoutput = new PersonaDTOoutput();

        return personaDTOoutput.toPersonaDTOoutput(persona);
    }


    //Con este método evito repetir código en getPersonsByName y getAllPersons
    List<PersonaDTOoutput> toListDTOoutput(List<Persona> personas){
        List<PersonaDTOoutput> personasDTO = new ArrayList();

        PersonaDTOoutput personaAuxiliar = new PersonaDTOoutput();

        for(Persona p: personas){
            personasDTO.add(personaAuxiliar.toPersonaDTOoutput(p));
        }
        return personasDTO;
    }


    @Override
    public List<PersonaDTOoutput> getPersonsByName(String name) throws Exception {
        List<Persona> personas = personaRepositorio.findByName(name);

        return toListDTOoutput(personas);
    }

    @Override
    public List<PersonaDTOoutput> getAllPersons() throws Exception {
        List<Persona> personas = personaRepositorio.findAll();

        return toListDTOoutput(personas);
    }



    //POST
    @Override
    public PersonaDTOoutput addPerson(PersonaDTOinput pers) throws Exception {
        if(pers == null){throw new Exception("Persona enviada es nulo.");}
        if(pers.getName().length()<6 || pers.getName().length()>10){throw new Exception("Persona enviada tiene un nombre cuya longitud no está entre 6 y 10 caracteres.");}

        personaRepositorio.saveAndFlush(pers.toEntity(pers));

        PersonaDTOoutput personaDTOoutput = new PersonaDTOoutput();
        return personaDTOoutput.toPersonaDTOoutput(pers.toEntity(pers));
    }



    //PUT
    @Override
    public PersonaDTOoutput updatePersona(PersonaDTOinput personaDTO, long id) throws Exception {
        if(personaRepositorio.findById(id).isEmpty()){throw new Exception("");}

        Persona p = personaDTO.toEntity(personaDTO);
        p.setId(id);
        personaRepositorio.saveAndFlush(p);

        PersonaDTOoutput personaDTOoutput = new PersonaDTOoutput();
        return personaDTOoutput.toPersonaDTOoutput(personaDTO.toEntity(personaDTO));
    }

    //DELETE
    @Override
    public void deletePersona(long id) throws Exception {
        if(personaRepositorio.findById(id).isEmpty()){throw new Exception("ID:'" + id + "' no existe en la base de datos.");}
        personaRepositorio.delete(personaRepositorio.findById(id).get());
    }
}
