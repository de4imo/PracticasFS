package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain.Profesor;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.StringPrefixedSequenceIdGenerator;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Estudiantes")
@Getter
@Setter
public class Student {
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
    private String id_student;

    @OneToOne(cascade = {CascadeType.ALL})    //???
    @JoinColumn(name = "ID_Persona")
    private Persona persona;

    @Column(name = "num_hours_week")
    @NotNull
    private int num_hours_week;

    @Column(name = "comments")
    private String comments;

    @JoinColumn(name = "id_profesor")
    @ManyToOne(fetch = FetchType.LAZY)
    private Profesor profesor;

    //@OneToMany(orphanRemoval = true, mappedBy = "estudiante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany(orphanRemoval = true,  mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "estudiante")    Solo se pone Joincolumn en el "dueño" de la relación
    private List<Estudiante_Asignatura> asignaturas = new ArrayList<>();

    @NotNull
    @Column(name = "branch")
    private String branch;


}
