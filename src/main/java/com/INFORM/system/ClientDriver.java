package com.INFORM.system;

import com.INFORM.Util.GenerateSchema;
import com.INFORM.annotation.Entity;
import com.INFORM.dao.Session;

import java.sql.SQLException;
import java.util.Set;

/** Just a simple placeholder for the prospected client */

public class ClientDriver {


    public static void main(String[] args) {
//        ClientBean user;
//        user = new ClientBean();
//
//        user.setName("Frank");
//        user.setAge(43);
//        user.setId(1);
//
//        //user.displayBean();


        //GenerateSchema gs = new GenerateSchema(user.getClass());

        Session ses = new Session();

        newtest t = new newtest();

        t.setId(55);
        try {
            ses.createTable(t.getClass());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



//        Session ses = new Session();
//
//        ses.display();


//        Reflections reflections = new Reflections();
      // Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Entity.class);
//
//        System.out.println("Entity cases found: " + classes.size());
//        for(Class<?> clazz : classes){
//            System.out.println(clazz);
//        }
    }

}


//        user = new ClientBean();
//        reflect = new GenerateReflection<>(user);
//System.out.println(reflect);

// reflect.writeObj(user,"ClientBean1.ser");