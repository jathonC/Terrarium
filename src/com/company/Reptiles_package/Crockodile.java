package com.company.Reptiles_package;

public class Crockodile extends Reptile {
    public Crockodile(int age, String name, boolean poisonous) {
        super(age, name, poisonous);
    }

    public  void  sing(){
        System.out.println(getClass());
    }
}
