package com.company.Reptiles_package;

public class Turtule extends Reptile {
    public Turtule(int age, String name, boolean poisonous) {
        super(age, name, poisonous);
    }

    public  void  sing(){
        System.out.println(getClass());
    }
}
