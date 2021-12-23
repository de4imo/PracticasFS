package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.infrastructure.controllers.dto.output;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTOoutput {

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

    public PersonaDTOoutput toPersonaDTOoutput(Persona persona){
        PersonaDTOoutput personaDTOoutput = new PersonaDTOoutput();
        //personaDTOoutput.set

        personaDTOoutput.setPassword(persona.getPassword());
        personaDTOoutput.setUsuario(persona.getUsuario());
        personaDTOoutput.setName(persona.getName());
        personaDTOoutput.setSurname(persona.getSurname());
        personaDTOoutput.setCompany_email(persona.getCompany_email());
        personaDTOoutput.setPersonal_email(persona.getPersonal_email());
        personaDTOoutput.setCity(persona.getCity());
        personaDTOoutput.setActive(persona.isActive());
        personaDTOoutput.setCreated_date(persona.getCreated_date());
        personaDTOoutput.setImagen_url(persona.getImagen_url());
        personaDTOoutput.setTermination_date(persona.getTermination_date());

        return personaDTOoutput;
    }
}
