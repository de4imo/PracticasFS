package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.application;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.application.dto.input.AsignaturaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.application.dto.output.AsignaturaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.domain.Asignatura;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.domain.AsignaturaRepository;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.NotFoundException;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IAsignaturaService implements AsignaturaServiceInterface{

    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Override
    public AsignaturaDTOoutput getAsignaturaById(String id) throws Exception {
        if(id==null){throw new UnprocesableException("ID nulo.");}

        Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe asignatura con id:" + id));

        return new AsignaturaDTOoutput(asignatura);
    }

    @Override
    //Con este método evito repetir código en getPersonsByName y getAllPersons
    public List<AsignaturaDTOoutput> toListDTOoutput(List<Asignatura> asignaturas){
        List<AsignaturaDTOoutput> asignaturaDTOoutputs = new ArrayList();

        for(Asignatura a: asignaturas){
            asignaturaDTOoutputs.add(new AsignaturaDTOoutput(a));
        }
        return asignaturaDTOoutputs;
    }

    @Override
    public List<AsignaturaDTOoutput> getAsignaturaByName(String name) throws Exception {
        if(name.isEmpty()){throw new UnprocesableException("Nombre de la asignatura nulo o vacío");}

        List<Asignatura> asignaturas = asignaturaRepository.findByName(name);

        if (asignaturas.isEmpty()){throw new NotFoundException("No existen asignaturas con nombre: " + name);}

        return toListDTOoutput(asignaturas);
    }

    @Override
    public List<AsignaturaDTOoutput> getAllAsignaturas() {
        List<Asignatura> asignaturas = asignaturaRepository.findAll();
        if(asignaturas.isEmpty()){throw new NotFoundException("No hay ninguna asignatura en la BBDD.");}

        return toListDTOoutput(asignaturas);
    }

    @Override
    public AsignaturaDTOoutput addAsignatura(AsignaturaDTOinput asignaturaDTOinput) throws Exception {
        if(asignaturaDTOinput == null){throw new UnprocesableException("Asignatura enviada es nula.");}
        if(asignaturaDTOinput.getName().length()<6 || asignaturaDTOinput.getName().length()>10){ throw new UnprocesableException("Nombre de la asignatura enviada es nulo o tiene menos de 6 caracteres.");}

        Asignatura asignatura = asignaturaRepository.saveAndFlush(asignaturaDTOinput.toEntity());

        return new AsignaturaDTOoutput(asignatura);
    }

    @Override
    public AsignaturaDTOoutput updateAsignatura(AsignaturaDTOinput asignaturaDTOinput, String id) throws Exception {
        validate(asignaturaDTOinput, id);

        Asignatura asignatura = asignaturaDTOinput.toEntity();
        asignatura.setId(id);
        asignaturaRepository.saveAndFlush(asignatura);

        return new AsignaturaDTOoutput(asignatura);
    }

    @Override
    public void deleteAsignatura(String id) throws Exception {
        if(asignaturaRepository.findById(id).isEmpty()){throw new NotFoundException("NotFoundException: No existe asignatura con id:" + id);}
        asignaturaRepository.delete(asignaturaRepository.findById(id).get());
    }

    private void validate(AsignaturaDTOinput asignaturaDTOinput, String id) throws Exception{
        if(asignaturaDTOinput == null){throw new UnprocesableException("UnprocesableException: no has enviado una signatura.");}
        if(asignaturaRepository.findById(id).isEmpty()){throw new NotFoundException("NotFoundException: No existe asignatura con id:" + id);}
        if(asignaturaDTOinput.getName().length()<6){throw new UnprocesableException("UnprocesableException: Asignatura enviada tiene un nombre con menos de 6 caracteres.");}
    }
}
