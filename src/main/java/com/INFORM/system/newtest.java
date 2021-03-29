package com.INFORM.system;


import com.INFORM.annotation.Entity;
import com.INFORM.annotation.PrimeKey;

@Entity
public class newtest {

    @PrimeKey
    private int id;
    private String name;
    private String second_message;

    public void setId(int n){this.id = n;}
    public void setName(String s){this.name = "new name";}

    public void setSecond_message() {
        this.second_message = "the second message";
    }
}
