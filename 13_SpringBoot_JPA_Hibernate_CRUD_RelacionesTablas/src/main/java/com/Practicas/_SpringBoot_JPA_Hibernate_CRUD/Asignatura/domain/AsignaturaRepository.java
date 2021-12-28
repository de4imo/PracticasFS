package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.domain;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignaturaRepository extends JpaRepository<Asignatura, String> {
    List<Asignatura> findByName(String name);
}
