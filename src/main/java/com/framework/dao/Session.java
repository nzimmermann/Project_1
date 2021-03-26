package com.framework.dao;


import com.framework.configuration.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Calendar;

public class Session {

    ConnectionUtil con;
    PreparedStatement pstmt;
    ResultSet rs;

    LocalTime begin = LocalTime.now();
    LocalTime finished;




    public Session(){
        try {
            pstmt = con.getInstance().getConnection().prepareStatement("SELECT * FROM STUDENTS");
            rs = pstmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void display(){
        System.out.println(rs);
    }



    public static void persist(Class<?> C){}
    public static void update() {}
    public static void persistOrUpdate() {}



    public static Object load(Class<?> loadable){
        return loadable;
    }

    public static boolean delete(Class<?> deleteThis){
        return true;
    }

    public static boolean createSqlQuery() {return true;}



}

//
//    {
//
//    }
