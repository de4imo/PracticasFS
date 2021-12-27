package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Asignatura.domain;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.StringPrefixedSequenceIdGenerator;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "estudiante_asignatura")
@Getter
@Setter
public class Asignatura {
    //    id_asignatura String [pk, increment]
    @Id
    @Column(name = "id_asignatura", unique = true)
    @GenericGenerator(
            name = "asignat",
            strategy = "com.Practicas._SpringBoot_JPA_Hibernate_CRUD.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ASIG"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    String id_asignatura;

    //    id_student string [ref: > student.id_student] -- Un estudiante puede tener N asignaturas
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    Student student;


                //@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "id_profesor")  //solo sale en los ejemplos
                //Profesor profesor;


    //    asignatura string -- Ejemplo: HTML, Angular, SpringBoot...
    @Column(name = "asignatura")
    String asignatura;

    //    coments string
    @Column(name = "comments")
    String comments;

    //    initial_date date [not null], -- Fecha en que estudiante empezó a estudiar la asignatura
    @NotNull
    @Column(name = "initial_date")
    Date initial_date;


    //    finish_date date -- Fecha en que estudiante termina de estudiar la asignatura
    @Column(name = "finish_date")
    Date finish_date;

}
