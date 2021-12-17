package com.Practicas._SpringBoot_CRUD;

import java.util.List;

public interface InterfCRUD {
    List<Person> getPersonList();
    void setPersonList(List<Person> personList);
   // public Integer ID;
}
