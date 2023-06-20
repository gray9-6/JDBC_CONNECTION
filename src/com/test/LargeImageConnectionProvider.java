package com.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class LargeImageConnectionProvider {

    private static  Connection connection;


    // getter of connection
    public  static Connection getConnection(){

            try{

                if(connection == null){
                    // loading the driver
                    //( if we don't want to do this then we can add the my sql connector to libraries)
//            Class.forName("com.mysql.cj.jdbc.Driver");

                    // creating connection
                    String url = "jdbc:mysql://localhost:3306/untilted";
                    String root = "root";
                    String password = "#@incorrect";
                    connection = DriverManager.getConnection(url,root,password);
                }

            } catch (Exception e){
                e.printStackTrace();
            }


        return connection;
    }

}
