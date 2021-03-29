package com.INFORM.dao;


import com.INFORM.SQL.CreateTable;
import com.INFORM.Util.Attribute;
import com.INFORM.Util.GenerateSchema;
import com.INFORM.Util.Schema;
import com.INFORM.configuration.ConnectionUtil;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;


public class Session {
    ResultSet rs;


    public Session(){ }


    public String createTable(Class<?> clazz) throws SQLException {
        GenerateSchema gs = new GenerateSchema(clazz);
        Schema s = gs.intoSchema(clazz);
        return createTable(s);
    }

    public String createTable(Schema scheme)  {
        ArrayList<Attribute> ats = scheme.getAttributes();
        StringBuilder sb = new StringBuilder();

        sb.append("CREATE TABLE ");
        sb.append(scheme.getTitle());
        sb.append("(");

        for(int i = 0; i < ats.size(); i++){
            sb.append(ats.get(i).getName() + " " + ats.get(i).getType() + (i==0 ? " PRIMARY KEY" : "") + (i==ats.size()-1 ? ")" : ", "));
        }


        String sql =  sb.toString();
                //ClientBean(id Int PRIMARY KEY, name VARCHAR(30), age INT )";
        Statement statement = null;
        try {
            statement = ConnectionUtil.getInstance().getConnection().createStatement();
            System.out.println(sb);
            ResultSet rs = statement.executeQuery(sql.trim());// executeQuery(sql);

            if(rs == null){
                return "it worked";
            }
        } catch (SQLException throwables) {

        }

        return "";
    }

    public ResultSet requestQuery(){

        return null;
    }


    public static void persist(Class<?> C){}
    public static void update() {}
    public static void persistOrUpdate() {}





}


//    public static Object load(Class<?> loadable){
//        return loadable;
//    }
//
//    public static boolean delete(Class<?> deleteThis){
//        return true;
//    }
//
//    public static boolean createSqlQuery() {return true;}

//        try {
//            PreparedStatement preparedStatement = ConnectionUtil.getInstance().getConnection().prepareStatement(
//                    "SELECT username FROM users WHERE username LIKE ?");
//            preparedStatement.setString(1, "j%");
//            rs = preparedStatement.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//    public void display(){
//        try {
//            while(rs.next()){
//                System.out.println(rs.getObject(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    String sql = "CREATE TABLE " + scheme.getTitle() + "(";


//        for(int i = 0; i < ats.size(); i++){
//            sql = sql + ats.get(i).getName() + " " + ats.get(i).getType() + ", ";
//        }