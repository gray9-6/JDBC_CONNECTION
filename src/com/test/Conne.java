package com.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conne {

    public Conne(){
        try{
            // loading the driver
            //( if we don't want to do this then we can add the my sql connector to libraries)
//            Class.forName("com.mysql.cj.jdbc.Driver");

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

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
