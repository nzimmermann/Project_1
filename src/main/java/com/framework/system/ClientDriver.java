package com.framework.system;

import com.sun.corba.se.spi.ior.ObjectKey;
import com.sun.org.apache.xml.internal.serialize.SerializerFactory;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;

/** Just a simple placeholder for the prospected client */

public class ClientDriver {


    public static void main(String[] args) {
        ClientBean user;
        user = new ClientBean();

        user.setName("Frank");
        user.setAge(43);
        user.setId(1);

        user.displayBean();

        //Object o = user.getClass();

        GenerateReflection<?> reflect = new GenerateReflection<>(user);
//        user = new ClientBean();
//        reflect = new GenerateReflection<>(user);
        //System.out.println(reflect);

        reflect.writeObj(user);
    }



}

