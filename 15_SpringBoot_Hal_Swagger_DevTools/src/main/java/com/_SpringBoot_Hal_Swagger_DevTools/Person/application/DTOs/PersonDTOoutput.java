package com._SpringBoot_Hal_Swagger_DevTools.Person.application.DTOs;

import com._SpringBoot_Hal_Swagger_DevTools.Person.domain.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PersonDTOoutput {
    private String name;
    private String surname;
    private long age;
    private String email;
    private String city;

    public PersonDTOoutput(Person person){
        this.name = person.getName();
        this.surname = person.getSurname();
        this.age = person.getAge();
        this.email = person.getEmail();
        this.city = person.getCity();
    }
}