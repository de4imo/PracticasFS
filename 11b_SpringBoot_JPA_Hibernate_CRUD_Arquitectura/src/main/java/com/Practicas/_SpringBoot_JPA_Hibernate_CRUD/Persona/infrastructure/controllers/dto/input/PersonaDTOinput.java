package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure.controllers.dto.input;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PersonaDTOinput {

    private String usuario;

    private String password;

    private String name;

    private String surname;

    private String company_email;

    private String personal_email;

    private String city;

    private boolean active;

    private Date created_date;

    private String imagen_url;

    private Date termination_date;

    public Persona toEntity(PersonaDTOinput personaDTOinput){
        Persona persona = new Persona();

        persona.setPassword(personaDTOinput.getPassword());
        persona.setUsuario(personaDTOinput.getUsuario());
        persona.setName(personaDTOinput.getName());
        persona.setSurname(personaDTOinput.getSurname());
        persona.setCompany_email(personaDTOinput.getCompany_email());
        persona.setPersonal_email(personaDTOinput.getPersonal_email());
        persona.setCity(personaDTOinput.getCity());
        persona.setActive(personaDTOinput.isActive());
        persona.setCreated_date(personaDTOinput.getCreated_date());
        persona.setImagen_url(personaDTOinput.getImagen_url());
        persona.setTermination_date(personaDTOinput.getTermination_date());

        return persona;
    }
}
