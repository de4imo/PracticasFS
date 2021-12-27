package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
