package com.framework.system;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;



public class TestingReflection {

    public static void main(String[] args) {
        Class reflectClass = ClientBean.class;

        String className = reflectClass.getName();

        System.out.println(className);

        int classModifier = reflectClass.getModifiers();

        System.out.println(Modifier.isPublic(classModifier));

        Class<?>[] interfaces = reflectClass.getInterfaces();
        Class<?> classSuper = reflectClass.getSuperclass();


        Method[] classMethods = reflectClass.getMethods();

        System.out.println("Method\t\t\tType\t\t\tParameters");
        for(Method method : classMethods){
            System.out.print(method.getName());
            System.out.print((method.getName().length() < 8? "\t\t\t" : "\t\t") + method.getReturnType());
            Class[] paramType = method.getParameterTypes();
            for(Class param : paramType){
                //System.out.print("\t\t\t" + param.getName());
            }

            System.out.println();
        }




    }


}
