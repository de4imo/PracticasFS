package com.Practicas._SpringBoot_CRUD_Records.domain;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);

    //public List<Person> getData(HashMap<String, Object> conditions, Pageable pageable);

    List<Person> getData(HashMap<String, Object> conditions, Pageable pageable);
}