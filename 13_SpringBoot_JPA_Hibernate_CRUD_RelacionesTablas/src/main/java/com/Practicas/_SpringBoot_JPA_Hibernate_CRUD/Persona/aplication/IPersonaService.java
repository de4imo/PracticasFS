package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.output.PersonaDTOoutputEstudiante;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.output.PersonaDTOoutputProfesor;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.PersonaRepositorio;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.input.PersonaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.output.PersonaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain.Profesor;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.NotFoundException;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IPersonaService implements PersonaServiceInterface {
    @Autowired
    PersonaRepositorio personaRepositorio;

    /*Método que solo devuelve un tipo de Output, en función del 'outputType' --> [URL]?outputType=[AQUI O 'full' o 'simple']:
        * PersonaDTOoutput por defecto ó si la URL--> ?outputType=simple
        * PersonaDTOoutputEstudiante si la persona es Estudiante & la URL--> ?outputType=full
        * PersonaDTOoutputProfesor si la persona es Profesor & la URL--> ?outputType=full*/
    private PersonaDTOoutput getOutputAccordingType(Persona persona, String type){

        if(type.equalsIgnoreCase("simple")){return new PersonaDTOoutput(persona);}

        PersonaDTOoutputEstudiante personaDTOoutputEstudiante = new PersonaDTOoutputEstudiante(persona);
        PersonaDTOoutputProfesor personaDTOoutputProfesor = new PersonaDTOoutputProfesor(persona);

        if(type.equalsIgnoreCase("full") && personaDTOoutputEstudiante.getStudentDTOoutput() != null){
            return personaDTOoutputEstudiante;
        }
        if(type.equalsIgnoreCase("full") && personaDTOoutputProfesor.getProfesorDTOoutput() != null){
            return personaDTOoutputProfesor;
        }

        return new PersonaDTOoutput(persona);
    }


    //Para obtener una lista (tanto si hemos buscado por nombres o queremos la lista completa)
    @Override
    public List<PersonaDTOoutput> toListDTOoutput(List<Persona> personas, String typeOfValue){
        List<PersonaDTOoutput> personasDTO = new ArrayList();

        for(Persona p: personas){
            if(typeOfValue.equalsIgnoreCase("simple")){
                personasDTO.add(new PersonaDTOoutput(p));
            }

            if(typeOfValue.equalsIgnoreCase("full")){
                personasDTO.add(getOutputAccordingType(p, "full"));
            }
        }
        return personasDTO;
    }


    //GET
    @Override
    public PersonaDTOoutput getPersonById(String id, String type) throws Exception {
        Persona persona = personaRepositorio.findById(id).orElseThrow(() -> new NotFoundException("No existe usuario con id:" + id));

         return getOutputAccordingType(persona, type);
    }


    @Override
    public List<PersonaDTOoutput> getPersonsByName(String name, String typeOfValue) throws Exception {

        if (personaRepositorio.findByName(name).isEmpty()) { throw  new NotFoundException("No hay ninguna persona con nombre: " + name + ".");}
        List<Persona> personas = personaRepositorio.findByName(name);

        return toListDTOoutput(personas, typeOfValue);
    }

    @Override
    public List<PersonaDTOoutput> getAllPersons(String typeOfValue) throws Exception {
        List<Persona> personas = personaRepositorio.findAll();
        if(personas.isEmpty()){ throw new NotFoundException("No hay personas.");}

        return toListDTOoutput(personas, typeOfValue);
    }



    //POST
    @Override
    public PersonaDTOoutput addPerson(PersonaDTOinput pers) throws Exception {
        if(pers == null){throw new UnprocesableException("Persona enviada es nulo.");}
        if(pers.getName().length()<6 || pers.getName().length()>10){throw new UnprocesableException("UnprocesableException: Persona enviada tiene un nombre cuya longitud no está entre 6 y 10 caracteres."); }

        Persona persona = pers.toEntity();

        personaRepositorio.saveAndFlush(persona);

        return new PersonaDTOoutput(persona);
    }



    //PUT
    @Override
    public PersonaDTOoutput updatePersona(PersonaDTOinput personaDTOinput, String id) throws Exception {
        if(personaRepositorio.findById(id).isEmpty()){throw new NotFoundException("No existe usuario con id:" + id);}
        if(personaDTOinput.getName().length()<6 || personaDTOinput.getName().length()>10){throw new UnprocesableException("UnprocesableException: Persona enviada tiene un nombre cuya longitud no está entre 6 y 10 caracteres.");}

        Persona persona = personaDTOinput.toEntity();
        persona.setId(id);
        personaRepositorio.saveAndFlush(persona);

       // return personaDTOoutput.toPersonaDTOoutput(personaDTO.toEntity(personaDTO));
        return new PersonaDTOoutput(persona);
    }

    //DELETE
    @Override
    public void deletePersona(String id) throws Exception {
        if(personaRepositorio.findById(id).isEmpty()){throw new NotFoundException("No existe estudiante con id:" + id);}
        personaRepositorio.delete(personaRepositorio.findById(id).get());
    }
}