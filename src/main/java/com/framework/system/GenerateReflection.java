package com.framework.system;

import com.sun.security.ntlm.Client;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class GenerateReflection<T> {

    private static Map<Class<?>, String[]> fieldMap;
    private static Map<Class<?>, String[]> methodMap;


    private Class<? super T> parent;
    private Class<? extends T> child;

    Class<?>[] params;


    public GenerateReflection(Class<T> klass){
        parse(klass);
    }

    public GenerateReflection(Object o) {
        parse(o);
    }


    public void parse(Object klass){

        System.out.println("\nHere's the reflection:\n");

        Class<?> reflectKlass = klass.getClass();
        String klassName = reflectKlass.getName();

//        System.out.println(klassName);
//        System.out.println(reflectKlass.toGenericString());

//        int classModifier = reflectKlass.getModifiers();
//        System.out.println(classModifier);

        Method[] classMethods = reflectKlass.getDeclaredMethods();

        for(Method method : classMethods){
            System.out.println("Method Name: " + method.toString());
            for(Type param : method.getGenericParameterTypes()){
                System.out.print(param + " ");
            }
            System.out.println();
        }

        Constructor<?>[] constructors = reflectKlass.getConstructors();

        for(Constructor construct : constructors){
            System.out.println(Arrays.toString(construct.getParameterTypes()));
        }

        ClientBean newBean = null;

        try {
           newBean = (ClientBean) constructors[1].newInstance("not-admin");
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


        System.out.println("The object passed in");
        ((ClientBean) klass).displayBean();
        System.out.println("\nMy new object");
        newBean.displayBean();
        System.out.println();

        System.out.println(reflectKlass.getCanonicalName());


        Serializable sfd;
    }

    public void writeObj(Object wo){

        try {
            FileOutputStream fileout = new FileOutputStream("ClientBean.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(wo);
            out.close();
            fileout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
