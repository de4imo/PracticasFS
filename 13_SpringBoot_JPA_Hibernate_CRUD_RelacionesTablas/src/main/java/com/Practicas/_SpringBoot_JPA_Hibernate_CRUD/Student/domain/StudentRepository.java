package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
   // @Query("select * from Estudiantes")
    List<Student> findByPersona(String name);
}
