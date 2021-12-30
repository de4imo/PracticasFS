package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Profesor.domain;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    private String id_profesor;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_Persona")
    private Persona personaProf;

    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "profesor")
    //@JoinColumn(name = "ID_Student")  Joincolumn solo se pone en el "dueño de la relación"
    List<Student> estudiantes;


    @Column(name = "comments")
    private String comments;

    @NotNull
    @Column(name = "branch")
    private String branch;
}
