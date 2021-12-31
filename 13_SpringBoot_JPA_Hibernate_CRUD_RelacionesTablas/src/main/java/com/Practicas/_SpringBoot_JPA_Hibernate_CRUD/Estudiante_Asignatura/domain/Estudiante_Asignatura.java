package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.domain;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.StringPrefixedSequenceIdGenerator;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Estudiante_Asignatura")
@Getter
@Setter
public class Estudiante_Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudAsig_seq")
    @GenericGenerator(
            name = "estudAsig_seq",
            strategy = "com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ESTUD_ASIG"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    @Column(name = "ID_Estudiante_Asignatura",unique = true)
    private String id;

    /*@ManyToOne(fetch = FetchType.LAZY, optional = true)       //  FUNCIONA
    @JoinColumn(name = "ID_Student")
    private Student student;*/

    @ManyToMany(fetch = FetchType.LAZY)         //PRUEBA
    @JoinColumn(name = "ID_Student")
    private List<Student> students;

    @Column(name = "name")
    private String name;

    @Column(name = "comments")
    private String comments;

    @NotNull
    @Column(name = "initial_date")
    private Date initial_date;

    @Column(name = "finish_date")
    private Date finish_date;

}
