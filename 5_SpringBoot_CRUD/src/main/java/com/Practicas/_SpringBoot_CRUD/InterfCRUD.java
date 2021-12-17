package com.Practicas._SpringBoot_CRUD;

import java.util.List;

public interface InterfCRUD {
    List<Person> getPersonList();

    void setPersonList(List<Person> personList);
    Person getPersonByID(int id);
    List<Person> getPersonsByName(String name);
    void setLastID(int id);
    int getLastID();
}
