package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByName(String name);
}
