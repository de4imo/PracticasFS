package com._SpringBoot_Docker_PostgreSQL_V2.Person.application.DTOs;

import com._SpringBoot_Docker_PostgreSQL_V2.Person.domain.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PersonDTOoutput {
    private String id;
    private String name;
    private String surname;
    private long age;
    private String email;
    private String city;

    public PersonDTOoutput(Person person){
        this.id = person.getId();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.age = person.getAge();
        this.email = person.getEmail();
        this.city = person.getCity();
    }
}