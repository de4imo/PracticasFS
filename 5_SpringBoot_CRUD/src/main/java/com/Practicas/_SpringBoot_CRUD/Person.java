package com.Practicas._SpringBoot_CRUD;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private String town;
    private int id;
}
