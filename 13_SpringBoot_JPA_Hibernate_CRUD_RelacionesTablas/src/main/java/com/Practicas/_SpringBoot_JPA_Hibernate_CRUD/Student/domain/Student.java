package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.StringPrefixedSequenceIdGenerator;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estudiantes")
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
    @GeneratedValue
    @GenericGenerator(
            name = "asignat",
            strategy = "com.Practicas._SpringBoot_JPA_Hibernate_CRUD.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "STUD"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    @Column(name = "id_student", unique = true)
    String id_student;

    @OneToOne//(cascade = {CascadeType.ALL})    //???
    @JoinColumn(name = "id_persona")
    Persona persona;

    @Column(name = "num_hours_week")
    @NotNull
    int num_hours_week;

    @Column(name = "comments")
    String comments;

    @Column(name = "id_profesor")
    @ManyToOne(fetch = FetchType.LAZY)
    String id_profesor;

    /*@NotNull
    enum branch{
        FRONT, BACK, FULLSTACK
    }*/

    @NotNull
    @Column(name = "branch")
    String branch;
}
