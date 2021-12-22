package com.Practicas._SpringBoot_JPA_Hibernate_CRUD;

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
    /*id_persona int [pk, increment]
usuario string [not null max-length: 10 min-length: 6]
password string [not null]
name string [not null]
surname string
company_email string [not null ]
personal_email string [not null]
city string [not null]
active boolean [not null]
created_date date [not null]
imagen_url string
termination_date date*/


    // @Column(name = "name", length = 128, nullable = false, unique = true)
    @Id
    @GeneratedValue //AUTO is the default strategy for @GeneratedValue., lo cual ya lo convierte en primary key??
    @Column(name = "id",unique = true)
    long id;

    @NotNull //@Min(13) @Max(110)
    @Column(name="nombre_de_usuario")
    //@Size(min = 6, max = 10)
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
