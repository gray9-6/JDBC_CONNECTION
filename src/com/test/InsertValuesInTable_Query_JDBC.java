package com.test;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

//Prepare Statement
public class InsertValuesInTable_Query_JDBC {
    public  void updateQuery() throws Exception{
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

            // Create query, inserting into table1
            String q = "insert into table1 (tName,tCity) values(?,?)";

            // get the prepared statement object
             PreparedStatement preparedStatement =  connection.prepareStatement(q);

             /* giving input
             // set the values to query
            preparedStatement.setString(1,"Ajay");
            preparedStatement.setString(2,"Haryana");  */

            // taking user input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Name :");
            String name = br.readLine();

            System.out.println("Enter city :");
            String city = br.readLine();

            preparedStatement.setString(1,name);
            preparedStatement.setString(2,city);

            // ends of user input

            preparedStatement.executeUpdate();

            System.out.println("Table updated");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        InsertValuesInTable_Query_JDBC update = new InsertValuesInTable_Query_JDBC();
        update.updateQuery();

    }
}
