package com.Practicas._SpringBoot_CRUD_Records.domain;

import com.Practicas._SpringBoot_CRUD_Records.application.DTOs.PersonaDTOinput;
import com.Practicas._SpringBoot_CRUD_Records.application.DTOs.PersonaDTOoutput;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Persona")
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "id",unique = true)
    long id;

    @NotNull //@Min(13) @Max(110)
    @Column(name="nombre_de_usuario")
    //@Size(min = 6, max = 10)
    String usuario;

    @NotNull
    String password;

    @NotNull
    String name;

    @NotNull
    String surname;

    @NotNull
    String company_email;

    @NotNull
    String personal_email;

    @NotNull
    String city;

    @NotNull
    boolean active;

    @NotNull
    Date created_date;

    String imagen_url;

    Date termination_date;

    //PersonaDTO other = (PersonaDTO) obj;


    public Person(PersonaDTOinput personaDTOinput){
        usuario = personaDTOinput.usuario();
        password = personaDTOinput.password();
        name = personaDTOinput.name();
        surname = personaDTOinput.surname();
        company_email = personaDTOinput.company_email();
        personal_email = personaDTOinput.personal_email();
        city = personaDTOinput.city();
        active = personaDTOinput.active();
        created_date = personaDTOinput.created_date();
        imagen_url = personaDTOinput.imagen_url();
        termination_date = personaDTOinput.termination_date();
    }



    public PersonaDTOoutput toPersonaDTOoutput(){
        PersonaDTOoutput personaDTOoutput = new PersonaDTOoutput
                (this.getId(),
                this.getUsuario(),
                this.getPassword(),
                this.getName(),
                this.getSurname(),
                this.getCompany_email(),
                this.getPersonal_email(),
                this.getCity(),
                this.isActive(),
                this.getCreated_date(),
                this.getImagen_url(),
                this.getTermination_date()
        );
        return personaDTOoutput;
    }
}
