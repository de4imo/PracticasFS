package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Estudiante_AsignaturaRepository extends JpaRepository<Estudiante_Asignatura, String> {
    List<Estudiante_Asignatura> findByName(String name);
}
