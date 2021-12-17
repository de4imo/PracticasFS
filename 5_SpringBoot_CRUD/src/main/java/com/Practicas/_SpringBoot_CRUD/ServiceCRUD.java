package com.Practicas._SpringBoot_CRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceCRUD implements  InterfCRUD{
    List<Person> personList;

    public List<Person> getPersonList() {return personList;}
    private Integer lastID = 999;

    public void setPersonList(List<Person> personList) {this.personList = personList;}

    public Person getPersonByID(int ID){
         for(int i =0; i<personList.size(); i++){
            if(personList.get(i).getId() == ID){
                return personList.get(i);
            }
        }
        return null;
    }

    public List<Person> getPersonsByName(String name){
        return personList.stream().filter(p -> p.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public void setLastID(int ID){
        this.lastID = ID;
    }

    public int getLastID(){
        return this.lastID;
    }
}
