package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.output.PersonaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//OUTPUT FULL CON DATOS DE Persona
public class StudentDTOoutputFull extends StudentDTOoutput{
    PersonaDTOoutput personaDTOoutput;  //

    public StudentDTOoutputFull(Student student){
        super(student);
        this.personaDTOoutput = new PersonaDTOoutput(student.getPersona());
    }
}