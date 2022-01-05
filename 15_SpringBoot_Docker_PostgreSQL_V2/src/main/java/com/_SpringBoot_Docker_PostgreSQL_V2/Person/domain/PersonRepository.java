package com._SpringBoot_Docker_PostgreSQL_V2.Person.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
    List<Person> findByName(String name);
}
