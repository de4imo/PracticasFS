package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepositorio extends JpaRepository<Persona, String> {
    List<Persona> findByName(String name);
    //void updatePersona (long id, Persona persona);
}



/*public class IPersonaRepositorio implements PersonaRepositorio {

    @Override
    @Query(blabla)
    List<Persona> findByName(String name);
    //void updatePersona (long id, Persona persona);
}*/