package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.application;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.application.dto.input.Estudiante_AsignaturaDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.application.dto.output.Estudiante_AsignaturaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.domain.Estudiante_AsignaturaRepository;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.StudentRepository;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.NotFoundException;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IEstudianteAsignaturaService implements Estudiante_AsignaturaServiceInterface {

    @Autowired
    Estudiante_AsignaturaRepository estudianteAsignaturaRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Estudiante_AsignaturaDTOoutput getAsignaturaById(String id) throws Exception {
        if(id==null){throw new UnprocesableException("ID nulo.");}

        Estudiante_Asignatura estudianteAsignatura = estudianteAsignaturaRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe asignatura con id:" + id));

        return new Estudiante_AsignaturaDTOoutput(estudianteAsignatura);
    }

    @Override
    public List<Estudiante_AsignaturaDTOoutput> toListDTOoutput(List<Estudiante_Asignatura> estudianteAsignaturas){
        List<Estudiante_AsignaturaDTOoutput> estudianteAsignaturaDTOoutputs = new ArrayList();

        for(Estudiante_Asignatura a: estudianteAsignaturas){
            estudianteAsignaturaDTOoutputs.add(new Estudiante_AsignaturaDTOoutput(a));
        }
        return estudianteAsignaturaDTOoutputs;
    }

    @Override
    public List<Estudiante_AsignaturaDTOoutput> getAsignaturaByName(String name) throws Exception {
        if(name.isEmpty()){throw new UnprocesableException("Nombre de la asignatura nulo o vacío");}

        List<Estudiante_Asignatura> estudianteAsignaturas = estudianteAsignaturaRepository.findByName(name);

        if (estudianteAsignaturas.isEmpty()){throw new NotFoundException("No existen asignaturas con nombre: " + name);}

        return toListDTOoutput(estudianteAsignaturas);
    }

    @Override
    public List<Estudiante_AsignaturaDTOoutput> getAllAsignaturas() {
        List<Estudiante_Asignatura> estudianteAsignaturas = estudianteAsignaturaRepository.findAll();
        if(estudianteAsignaturas.isEmpty()){throw new NotFoundException("No hay ninguna asignatura en la BBDD.");}

        return toListDTOoutput(estudianteAsignaturas);
    }

    @Override
    public Estudiante_AsignaturaDTOoutput addAsignatura(Estudiante_AsignaturaDTOinput estudianteAsignaturaDTOinput) throws Exception {
        if(estudianteAsignaturaDTOinput == null){throw new UnprocesableException("Asignatura enviada es nula.");}
        if(estudianteAsignaturaDTOinput.getName().length()<3){ throw new UnprocesableException("Nombre de la asignatura enviada es nulo o tiene menos de 3 caracteres (nombre: '" + estudianteAsignaturaDTOinput.getName() + "')");}

        Estudiante_Asignatura estudianteAsignatura = estudianteAsignaturaRepository.saveAndFlush(estudianteAsignaturaDTOinput.toEntity());

        return new Estudiante_AsignaturaDTOoutput(estudianteAsignatura);
    }

    @Override
    public Estudiante_AsignaturaDTOoutput updateAsignatura(Estudiante_AsignaturaDTOinput estudianteAsignaturaDTOinput, String id) throws Exception {
        validate(estudianteAsignaturaDTOinput, id);

        Estudiante_Asignatura estudianteAsignatura = estudianteAsignaturaDTOinput.toEntity();
        estudianteAsignatura.setId(id);
        estudianteAsignaturaRepository.saveAndFlush(estudianteAsignatura);

        return new Estudiante_AsignaturaDTOoutput(estudianteAsignatura);
    }

    @Override
    public void deleteAsignatura(String id) throws Exception {
        if(estudianteAsignaturaRepository.findById(id).isEmpty()){throw new NotFoundException("NotFoundException: No existe asignatura con id:" + id);}
        estudianteAsignaturaRepository.delete(estudianteAsignaturaRepository.findById(id).get());
    }

    private void validate(Estudiante_AsignaturaDTOinput estudianteAsignaturaDTOinput, String id) throws Exception{
        if(estudianteAsignaturaDTOinput == null){throw new UnprocesableException("UnprocesableException: no has enviado una signatura.");}
        if(estudianteAsignaturaRepository.findById(id).isEmpty()){throw new NotFoundException("NotFoundException: No existe asignatura con id:" + id);}
        if(estudianteAsignaturaDTOinput.getName().length()<6){throw new UnprocesableException("UnprocesableException: Asignatura enviada tiene un nombre con menos de 6 caracteres.");}
    }
}
