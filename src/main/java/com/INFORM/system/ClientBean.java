package com.INFORM.system;

import com.INFORM.annotation.Entity;
import com.INFORM.annotation.PrimeKey;


@Entity
public class ClientBean {

    @PrimeKey
    private int id;
    private String name;
    private int age;


    public ClientBean(){
        id = 0;
        name = "admin";
        age = 100;

    }

    public ClientBean(String name){
        this.name = name;
    }


    public void setId(int i){this.id = i;}
    public int getId(){return this.id;}

    protected void setName(String s){this.name = s;}
    public String getName(){return this.name;}

    public void setAge(int age) {this.age = age;}
    private int getAge(){return age;}



    public void displayBean(){
        System.out.println("Displaying user info");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("ID: " + getId());
    }


}
