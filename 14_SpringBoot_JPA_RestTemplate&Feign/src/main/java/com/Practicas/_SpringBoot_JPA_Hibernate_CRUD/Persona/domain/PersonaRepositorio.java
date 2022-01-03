package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain.Profesor;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaRepositorio extends JpaRepository<Persona, String> {
    List<Persona> findByName(String name);
    //void updatePersona (long id, Persona persona);

  /*  //NUEVO: no sé si funciona
    Profesor findProfesor();
    Student findStudent();*/

   /* @Query("SELECT u FROM Profesor u WHERE u.Persona.ID_Persona = ?1")
    Profesor findProfesor(String id);



    //@Query("SELECT u FROM Student u WHERE u.Persona.ID_Persona = ?1")
    Student findStudent(String id);*/

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