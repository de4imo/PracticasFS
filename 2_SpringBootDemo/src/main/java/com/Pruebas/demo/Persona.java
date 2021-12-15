package com.Pruebas.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
//@Data
public class Persona {
    private String name;
    private Integer edad;
    private String ciudad;

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", edad=" + edad +
                ", poblacion='" + ciudad + '\'' +
                '}';
    }
}