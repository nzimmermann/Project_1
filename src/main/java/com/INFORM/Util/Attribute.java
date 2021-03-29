package com.INFORM.Util;

import java.lang.reflect.Field;
import java.sql.SQLType;
import java.util.regex.Pattern;

public class Attribute {
    private final String name;
    private final Field refField;

    public Attribute(Field f){
        this.name = f.getName();
        this.refField = f;
    }

    public String getName() {
        return name;
    }

    public Field getRefField() {
        return refField;
    }

    public String getType(){
        String temp = getRefField().getType().getTypeName();

        if(temp.contains(".")){
            String[] fp = temp.split(Pattern.quote("."));
            return "VARCHAR(100)";
        }


        switch(temp){
            case "int":
                return "INT";

            case "String":
                return "VARCHAR(" + (temp.length()*2) + ")";

        }

        return temp;
    }
}
