package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Profesores")
@Getter
@Setter
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profe_seq")
    @GenericGenerator(
            name = "profe_seq",
            strategy = "com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PROF"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    @Column(name = "ID_Profesor",unique = true)
    String id_profesor;


    //    id_persona string [ref:- persona.id_persona] -- Relación OneToOne con la tabla persona.
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_Persona")
    Persona persona;

    //    coments string
    @Column(name = "comments")
    String comments;


    //    branch string [not null] -- Materia principal que imparte. Por ejemplo: Front
    @NotNull
    @Column(name = "branch")
    String branch;

}
