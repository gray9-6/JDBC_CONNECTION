package com.test;

import java.sql.*;

public class InsertQuery_JDBC_CreateTable {

    public  void insertQuery() throws Exception{
       try{
           // Creating the connection
           String url = "jdbc:mysql://localhost:3306/untilted";
           Connection connection = DriverManager.getConnection(url,"root","#@incorrect");
           // create a statement
           Statement statement = connection.createStatement();

           // check karo connection bana hai ya nahi
           if(connection.isClosed()){
               System.out.println("connection is closed");
           } else{
               System.out.println("connection is created....");
           }
           String q = "create table table1(tId int(20) primary key auto_increment," +
                   "tName Varchar(200) not null, tCity Varchar(200))";

           // fire query
           statement.executeUpdate(q);

           System.out.println("Table created");

       } catch (Exception e){
           e.printStackTrace();
       }
    }


    public static void main(String[] args) throws Exception {
        InsertQuery_JDBC_CreateTable insert = new InsertQuery_JDBC_CreateTable();
        insert.insertQuery();

    }
}
