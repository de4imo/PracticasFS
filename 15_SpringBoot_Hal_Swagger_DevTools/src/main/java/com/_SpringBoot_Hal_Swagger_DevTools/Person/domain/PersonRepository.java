package com._SpringBoot_Hal_Swagger_DevTools.Person.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
    List<Person> findByName(String name);
}
