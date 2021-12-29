package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.StringPrefixedSequenceIdGenerator;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name = "Personas")
@Getter
@Setter
public class Persona {

    // @Column(name = "name", length = 128, nullable = false, unique = true)
    @Id
    //@GeneratedValue //AUTO is the default strategy for @GeneratedValue., lo cual ya lo convierte en primary key??
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perso_seq")
    @GenericGenerator(
            name = "perso_seq",
            strategy = "com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PERS"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    @Column(name = "ID_Persona",unique = true)
    //@GeneratedValue(generator = "uuid")
    //@GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;

    @NotNull //@Min(13) @Max(110)
    @Column(name="nombre_de_usuario")
    @Size(min = 6, max = 10)
    String usuario;

    @Column(name="password")
    @NotNull
    String password;

    @Column(name="name")
    @NotNull
    String name;

    @Column(name="surname")
    @NotNull
    String surname;

    @Column(name="company_email")
    @NotNull
    String company_email;

    @Column(name="personal_email")
    @NotNull
    String personal_email;

    @Column(name="city")
    @NotNull
    String city;

    @Column(name="active")
    @NotNull
    boolean active;

    @Column(name="created_date")
    @NotNull
    Date created_date;

    @Column(name="imagen_url")
    String imagen_url;

    @Column(name="termination_date")
    Date termination_date;

   /*public PersonaDTOoutput toPersonaOutput (){
        PersonaDTOoutput personaDTOoutput = new PersonaDTOoutput();

        personaDTOoutput.setPassword(password);
        personaDTOoutput.setUsuario(usuario);
        personaDTOoutput.setName(name);
        personaDTOoutput.setSurname(surname);
        personaDTOoutput.setCompany_email(company_email);
        personaDTOoutput.setPersonal_email(personal_email);
        personaDTOoutput.setCity(city);
        personaDTOoutput.setActive(active);
        personaDTOoutput.setCreated_date(created_date);
        personaDTOoutput.setImagen_url(imagen_url);
        personaDTOoutput.setTermination_date(termination_date);

        return personaDTOoutput;
    }*/
}
