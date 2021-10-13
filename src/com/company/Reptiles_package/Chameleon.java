package com.company.Reptiles_package;

public class Chameleon extends Scaly {
    public Chameleon(int age, String name, boolean poisonous) {
        super(age, name, poisonous);
    }
    public  void  sing(){

        System.out.println("123" + getClass());
    }
}
