package com.INFORM.Util;

import java.lang.reflect.*;
import java.util.*;
import java.util.regex.Pattern;


public class Schema {

    private String fullPath;
    private String title;
    private ArrayList<Attribute> attributes;

    private final Class<?> reflectKlass;

    //Class name -> Table name
    //Parameters -> Attributes (column names)

    public Schema(Class<?> klass){
        reflectKlass = klass;
        /* TABLE TITLE */
        setFullPath();
        setTitle();
        /* ATTRIBUTES */
        attributes = gatherAttributes();
    }


    private void setFullPath(){
        fullPath = reflectKlass.getName();
    }
    private void setTitle(){
        String[] fp = reflectKlass.getName().split(Pattern.quote("."));
        title = fp[fp.length-1];
    }

    private ArrayList<Attribute> gatherAttributes(){
        ArrayList<Attribute> results = new ArrayList<>();
        Field[] fields = reflectKlass.getDeclaredFields();

        for(Field f : fields){
            results.add(new Attribute(f));
        }
       return results;
    }

    public String getTitle(){
        return this.title;
    }

    public ArrayList<Attribute> getAttributes(){
        return attributes;
    }

}





//
//    private ArrayList<Attribute> gatherAttributes(Object o){
//        String title = gatherTitle(o);
//        ArrayList<Attribute> results = new ArrayList<>();
//
//        Field[] params = reflectKlass.getDeclaredFields();
//
//        /* TABLE ATTRIBUTES */
//        ArrayList<String> attributeFullNames = new ArrayList<>();
//        ArrayList<String> attributeNames = new ArrayList<>();
//        for (Field param : params){
//            attributeFullNames.add(param.toString());
//        }
//        for(String atr : attributeFullNames){
//            String[] temp = atr.split(" ");
//            String fullName = temp[temp.length-1];
//            attributeNames.add(fullName.substring(title.length()+1));
//        }
//
//        for(int i = 0; i < attributeFullNames.size(); i++){
//            //System.out.println(attributeFullNames.get(i) + " : " + attributeNames.get(i));
//            results.add(new Attribute(attributeFullNames.get(i), attributeNames.get(i)));
//        }
//
//        return results;
//    }






//        int classModifier = reflectKlass.getModifiers();
//        System.out.println(classModifier);


//        try {
//           newBean = (ClientBean) constructors[1].newInstance("not-admin");
//        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
//            e.printStackTrace();
//        }



//    public void writeObj(Object wo, String filename){
//
//        try {
//            FileOutputStream fileout = new FileOutputStream("ClientBean.ser");
//            ObjectOutputStream out = new ObjectOutputStream(fileout);
//            out.writeObject(wo);
//            out.close();
//            fileout.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }




//        Method[] classMethods = reflectKlass.getDeclaredMethods();
//
//        for(Method method : classMethods){
//            System.out.println("Method Name: " + method.toString());
//            for(Type param : method.getGenericParameterTypes()){
//                System.out.print(param + " ");
//            }
//            System.out.println();
//        }
//
//
//        System.out.println(reflectKlass.toGenericString());
//
//        Constructor<?>[] constructors = reflectKlass.getConstructors();
//
//        for(Constructor<?> construct : constructors){
//            System.out.println(Arrays.toString(construct.getParameterTypes()));
//        }
//
//
//        System.out.println(reflectKlass.getCanonicalName());


//    public void displayParse(){
//
//        System.out.println("\nHere's the reflection to become schema:");
//
//        System.out.print(title + "(");
//        for (Attribute a : attributes){
//            System.out.print(a.getName() + " " + a.getType() + ", ");
//        }
//        System.out.println("\b\b) ");
//
//    }