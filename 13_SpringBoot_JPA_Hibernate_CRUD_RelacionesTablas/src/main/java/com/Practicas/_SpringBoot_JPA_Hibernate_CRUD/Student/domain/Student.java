package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain.Profesor;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.StringPrefixedSequenceIdGenerator;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Estudiantes")
@Getter
@Setter
public class Student {
/*  id_student string [pk, increment]
    id_persona string [ref:- persona.id_persona] -- Relación OneToOne con la tabla persona.
    num_hours_week int [not null] -- Número de horas semanales del estudiante en formación
    coments string
    id_profesor string [ref: > profesor.id_profesor] -- Un estudiante solo puede tener un profesor.
    branch string [not null] -- Rama principal delestudiante (Front, Back, FullStack)*/

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stud_seq")
    @GenericGenerator(
            name = "stud_seq",
            strategy = "com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "STUD"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    @Column(name = "ID_Student", unique = true)
    String id_student;

    @OneToOne(cascade = {CascadeType.ALL})    //???
    @JoinColumn(name = "ID_Persona")
    Persona persona;

    @Column(name = "num_hours_week")
    @NotNull
    int num_hours_week;

    @Column(name = "comments")
    String comments;

   /* @JoinColumn(name = "id_profesor")
    @ManyToOne(fetch = FetchType.LAZY)
    Profesor profesor;*/
    //String id_profesor;

    /*@NotNull          //???
    enum branch{
        FRONT, BACK, FULLSTACK
    }*/

    @NotNull
    @Column(name = "branch")
    String branch;
}
