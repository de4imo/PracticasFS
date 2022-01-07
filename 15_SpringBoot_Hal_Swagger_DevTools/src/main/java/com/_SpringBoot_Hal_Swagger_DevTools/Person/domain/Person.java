package com._SpringBoot_Hal_Swagger_DevTools.Person.domain;

import com._SpringBoot_Hal_Swagger_DevTools.common.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "Person")
@Data
@NoArgsConstructor
public class Person {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
   /* @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perso_seq")
    @GenericGenerator(
            name = "perso_seq",
            strategy = "com._SpringBoot_Hal_Swagger_DevTools.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PERS"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String id;*/
    private String id;
    private String name;
    private String surname;
    private long age;
    private String email;
    private String city;
}
