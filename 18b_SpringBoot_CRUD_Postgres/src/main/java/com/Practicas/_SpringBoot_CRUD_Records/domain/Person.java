package com.Practicas._SpringBoot_CRUD_Records.domain;

import com.Practicas._SpringBoot_CRUD_Records.application.DTOs.PersonaDTOinput;
import com.Practicas._SpringBoot_CRUD_Records.application.DTOs.PersonaDTOoutput;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PERSONAS")
@Data
@NoArgsConstructor
//@EnableAutoConfiguration
@TableGenerator(name = "PERSONAS") //, initialValue = 30)
public class Person {
    //@TableGenerator(name = "PERSONAS", initialValue = 30)
    @Id
    // Sin @GeneratedValue ni @GenericGenerator con estos parámetros....
    // se produce un error cuando tratamos de hacer un POST, porque...
    // no revisa el último ID sino que genera un 1, aunque ya haya varios registros.
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    @Column(name = "id",unique = true)
    private long id;

    @NotNull //@Min(13) @Max(110)
    @Column//(name="nombre_de_usuario")
    //@Size(min = 6, max = 10)
    private String usuario;

    @Column
    @NotNull
    private String password;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String surname;

    @Column
    @NotNull
    private String company_email;

    @Column
    @NotNull
    private String personal_email;

    @Column
    @NotNull
    private String city;

    @Column
    @NotNull
    private boolean active;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created_date;

    @Column
    private String imagen_url;

    @Column
    private Date termination_date;

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
