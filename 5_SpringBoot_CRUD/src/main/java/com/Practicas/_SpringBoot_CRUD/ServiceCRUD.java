package com.Practicas._SpringBoot_CRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceCRUD implements  InterfCRUD{
    List<Person> personList;

    public List<Person> getPersonList() {return personList;}

    public void setPersonList(List<Person> personList) {this.personList = personList;}

    private Integer lastID = 999;
    //public void addPersona(Person pers){this.personList.add(pers);}

    public Person getPersonByID(int ID){
         for(int i =0; i<personList.size(); i++){
            if(personList.get(i).getId() == ID){
                return personList.get(i);
            }
        }
        return null;
    }
    /*public List<Person> getPersonByID(Integer ID){
        List<Person> newListaP = personList.stream().filter(p -> p.getID() == ID).collect(Collectors.toList());

       /* for(int i =0; i<personList.size(); i++){
            if(personList.get(i).getID() == ID){
                return personList.get(i);
            }
        }
        return newListaP;
    }*/

    public List<Person> getPersonsByName(String name){
        List<Person> newListaP = personList.stream().filter(p -> p.getName().equalsIgnoreCase(name)).collect(Collectors.toList());


        return newListaP;
    }

    public void setLastID(Integer ID){
        this.lastID = ID;
    }

    public Integer getLastID(){
        return this.lastID;
    }
}
