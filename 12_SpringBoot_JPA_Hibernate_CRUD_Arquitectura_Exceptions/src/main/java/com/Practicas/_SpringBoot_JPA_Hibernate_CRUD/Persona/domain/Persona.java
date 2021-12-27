package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Data
public class Persona {

    // @Column(name = "name", length = 128, nullable = false, unique = true)
    @Id
    @GeneratedValue //AUTO is the default strategy for @GeneratedValue., lo cual ya lo convierte en primary key??
    @Column(name = "ID",unique = true)
    long id;

    @NotNull //@Min(13) @Max(110)
    @Column(name="nombre_de_usuario")
    @Size(min = 6, max = 10)
    String usuario;

    @NotNull
    String password;

    @NotNull
    String name;

    @NotNull
    String surname;

    @NotNull
    String company_email;

    @NotNull
    String personal_email;

    @NotNull
    String city;

    @NotNull
    boolean active;

    @NotNull
    Date created_date;

    String imagen_url;

    Date termination_date;
}
