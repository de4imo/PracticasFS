package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesorRepositorio extends JpaRepository<Profesor, String> {
    List<Profesor> findByName(String name);
    //void updateProfesor (long id, Profesor profesor);
}



/*public class IPersonaRepositorio implements PersonaRepositorio {

    @Override
    @Query(blabla)
    List<Persona> findByName(String name);
    //void updatePersona (long id, Persona persona);
}*/