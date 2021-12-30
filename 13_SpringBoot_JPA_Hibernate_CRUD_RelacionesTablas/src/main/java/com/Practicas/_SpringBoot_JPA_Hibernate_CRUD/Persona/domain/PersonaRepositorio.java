package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain.Profesor;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepositorio extends JpaRepository<Persona, String> {
    List<Persona> findByName(String name);
    //void updatePersona (long id, Persona persona);

    //NUEVO: no sé si funciona
    Profesor getProfesor();
    Student getStudent();

    //NUEVO: Segunda Idea:
    //Profesor getID_Persona();
    //Student getID_Persona();
}



/*public class IPersonaRepositorio implements PersonaRepositorio {

    @Override
    @Query(blabla)
    List<Persona> findByName(String name);
    //void updatePersona (long id, Persona persona);
}*/