package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.output.PersonaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.input.ProfesorDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.application.dto.output.ProfesorDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain.Profesor;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain.ProfesorRepositorio;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.NotFoundException;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IProfesorService implements ProfesorServiceInterface{
    @Autowired
    ProfesorRepositorio profesorRepositorio;

////////////////
    public List<ProfesorDTOoutput> toListDTOoutput(List<Profesor> profesores) {
        List<ProfesorDTOoutput> profesoresDTO = new ArrayList();

        for(Profesor p: profesores){
            profesoresDTO.add(new ProfesorDTOoutput(p));
        }
        return profesoresDTO;
    }
///////////////

    //GET
    @Override
    public ProfesorDTOoutput getProfesorById(String id) throws Exception {
        Profesor profesor = profesorRepositorio.findById(id).orElseThrow(() -> new NotFoundException("No existe profesor con id:" + id));

        return new ProfesorDTOoutput(profesor);
    }


    @Override
    public List<ProfesorDTOoutput> getProfesoresByName(String name) throws Exception {
        if (profesorRepositorio.findByName(name).isEmpty()) { throw  new NotFoundException("No hay ningún profesor con nombre: " + name + ".");}
        List<Profesor> profesores = profesorRepositorio.findByName(name);

        return toListDTOoutput(profesores);
    }

    @Override
    public List<ProfesorDTOoutput> getAllProfesores() throws Exception {
        List<Profesor> profesores = profesorRepositorio.findAll();
        if(profesores.isEmpty()){ throw new NotFoundException("No hay profesores.");}

        return toListDTOoutput(profesores);
    }

    //POST
    @Override
    public ProfesorDTOoutput addProfesor(ProfesorDTOinput profesorDTOinput) throws Exception {
        if(profesorDTOinput == null){throw new UnprocesableException("Profesor enviada es nulo.");}

        Profesor profesor = profesorDTOinput.toEntity();

        profesorRepositorio.saveAndFlush(profesor);

        return new ProfesorDTOoutput(profesor);
    }

    //PUT
    @Override
    public ProfesorDTOoutput updateProfesor(ProfesorDTOinput profesorDTOinput, String id) throws Exception {
        if(profesorRepositorio.findById(id).isEmpty()){throw new NotFoundException("No existe usuario con id:" + id);}

        Profesor profesor = profesorDTOinput.toEntity();
        profesor.setId_profesor(id);
        profesorRepositorio.saveAndFlush(profesor);

        return new ProfesorDTOoutput(profesor);
    }

    //DELETE
    @Override
    public void deleteProfesor(String id) throws Exception {
        if(profesorRepositorio.findById(id).isEmpty()){throw new NotFoundException("No existe profesor con id:" + id);}
        profesorRepositorio.delete(profesorRepositorio.findById(id).get());
    }
}
