package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain.Profesor;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
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

    @Id
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
    private String id;

    @NotNull
    @Column(name="nombre_de_usuario")
    @Size(min = 6, max = 10)
    private String usuario;

    @Column(name="password")
    @NotNull
    private String password;

    @Column(name="name")
    @NotNull
    private String name;

    @Column(name="surname")
    @NotNull
    private String surname;

    @Column(name="company_email")
    @NotNull
    private String company_email;

    @Column(name="personal_email")
    @NotNull
    private String personal_email;

    @Column(name="city")
    @NotNull
    private String city;

    @Column(name="active")
    @NotNull
    boolean active;

    @Column(name="created_date")
    @NotNull
    private Date created_date;

    @Column(name="imagen_url")
    private String imagen_url;

    @Column(name="termination_date")
    private Date termination_date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "personaProf")
    private Profesor profesor;

    @OneToOne(mappedBy = "persona", fetch = FetchType.LAZY)
    @JoinColumn(name  = "personaStud")
    private Student student;
}
