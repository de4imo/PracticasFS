package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IDsAsignaturaEstudianteWrapper {
    private List<String> ids_AsignaturaEstudiante;
}
