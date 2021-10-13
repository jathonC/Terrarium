package com.company.Reptiles_package;

public class Snake extends  Scaly{
    public Snake(int age, String name, boolean poisonous) {
        super(age, name, poisonous);
    }

    public  void  sing(){
        System.out.println(getClass());
    }
}
