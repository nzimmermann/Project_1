package com.INFORM.Util;

import com.INFORM.annotation.Entity;
import com.INFORM.configuration.ConnectionUtil;
import org.reflections.Reflections;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class GenerateSchema {

    private Set<Class<?>> getEntities(){
        Reflections reflections = new Reflections();
        return reflections.getTypesAnnotatedWith(Entity.class);
    }


    public GenerateSchema(Class<?> c){
        intoSchema(c);
    }
    public GenerateSchema(){
        Set<Class<?>> Ents = getEntities();
        Set<Schema> schemes = new HashSet<>();
        for(Class<?> entity : Ents){
            schemes.add(intoSchema(entity));
        }
    }

    public Schema intoSchema(Class<?> clazz){
        return new Schema(clazz);
    }

    public Schema getSchema(Class<?> clazz){
        return  intoSchema(clazz);
    }

}
