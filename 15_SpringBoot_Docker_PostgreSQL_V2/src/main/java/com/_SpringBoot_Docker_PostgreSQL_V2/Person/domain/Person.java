package com._SpringBoot_Docker_PostgreSQL_V2.Person.domain;

import com._SpringBoot_Docker_PostgreSQL_V2.common.StringPrefixedSequenceIdGenerator;
import lombok.Data;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perso_seq")
    @GenericGenerator(
            name = "perso_seq",
            strategy = "com._SpringBoot_Docker_PostgreSQL_V2.common.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PERS"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    @Column(name = "id",unique = true)
    private String id;
    private String name;
    private String surname;
    private long age;
    private String email;
    private String city;
}
