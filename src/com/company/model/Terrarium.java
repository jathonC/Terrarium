package com.company.model;

import com.company.Reptiles_package.Reptile;

import java.util.List;

public class Terrarium {

    private String name;

    private List<Reptile> reptilies;
    private List<People> people;

    public void setName(String name) {
        this.name = name;
    }

    public void setReptiles(List<Reptile> reptilies) {
        this.reptilies = reptilies;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public List<Reptile> getReptilies() {
        return reptilies;
    }

    public List<People> getPeople() {
        return people;
    }

    @Override
    public String toString() {
        return "Terrarium{" +
                "name='" + name + '\'' +
                ", reptilies =" + reptilies +
                '}';
    }
}
