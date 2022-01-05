package com._SpringBoot_Docker_PostgreSQL_V2.Person.application.DTOs;

import com._SpringBoot_Docker_PostgreSQL_V2.Person.domain.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDTOinput {
    private String name;
    private String surname;
    private long age;
    private String email;
    private String city;

    public Person toEntity(){
        Person person = new Person();
        person.setName(this.name);
        person.setSurname(this.surname);
        person.setAge(this.age);
        person.setCity(this.city);
        person.setEmail(this.email);
        return person;
    }
}
