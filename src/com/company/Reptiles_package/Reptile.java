package com.company.Reptiles_package;

public abstract class Reptile {
    private int age;
    private String name;
    private boolean poisonous;

    public Reptile() {
    }

    public Reptile(int age, String name, boolean poisonous) {
        this.age = age;
        this.name = name;
        this.poisonous = poisonous;
    }
    public  void  sing(){
        System.out.println(getClass());
    }
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isPoisonous() {
        return poisonous;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoisonous(boolean poisonous) {
        this.poisonous = poisonous;
    }

    @Override
    public String toString() {
        return "Reptilies{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", poison=" + poisonous +
                '}';
    }
}
