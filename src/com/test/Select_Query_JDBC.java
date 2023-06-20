package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select_Query_JDBC {
    public static void main(String[] args) {
        try{
            Connection connection = LargeImageConnectionProvider.getConnection();

            String q = "select * from table1";
            // ye normal query hai isliye hum create statement laga rhe hai
            Statement statement = connection.createStatement();
            // execute query se hume data mil jaayega ,, or hum use result set mein store kar lenge
            ResultSet resultSet = statement.executeQuery(q);

            while (resultSet.next()){

                /*By Passing column Name*/
                // hum data se pehel ,, id nikal lenge
                int id = resultSet.getInt("tId");
                // ab name nikal lenge
                String name = resultSet.getString("tName");
                // ab city nikal lenge
                String city = resultSet.getString("tCity");


                // we can also get by passing column Number
                /*
                 // hum data se pehel ,, id nikal lenge
                int id = resultSet.getInt(1);
                // ab name nikal lenge
                String name = resultSet.getString(2);
                // ab city nikal lenge
                String city = resultSet.getString(3);

                 */
                System.out.println("Student id :-" + id + " Student Name :-  " + name + " City :- " + city);
            }

            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
