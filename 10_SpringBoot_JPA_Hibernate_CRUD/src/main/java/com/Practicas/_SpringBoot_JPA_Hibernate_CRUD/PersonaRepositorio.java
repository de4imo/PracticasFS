package com.Practicas._SpringBoot_JPA_Hibernate_CRUD;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepositorio extends JpaRepository<Persona, Long> {
    List<Persona> findByName(String name);
    //void updatePersona (long id, Persona persona);
}