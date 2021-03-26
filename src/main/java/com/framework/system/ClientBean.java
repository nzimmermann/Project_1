package com.framework.system;

import sun.net.www.content.text.Generic;

import java.io.Serializable;

public class ClientBean implements Serializable {
    private static final long serialVersionUID = 3487869381955025250L;

    private int id;
    private String name;
    private int age;
    private String mesg;

    public ClientBean(){
        id = 0;
        name = "admin";
        age = 100;
        mesg = "junk";
    }

    public ClientBean(String name){
        this.name = name;
        this.mesg = "This is an updated class implementation.";
    }


    public void setId(int i){this.id = i;}
    public int getId(){return this.id;}

    protected void setName(String s){this.name = s;}
    public String getName(){return this.name;}

    public void setAge(int age) {this.age = age;}
    private int getAge(){return age;}

    private String showMessage(){return mesg;}

    public void displayBean(){
        System.out.println("Displaying user info");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("ID: " + getId());
        System.out.println(showMessage());
    }



}
