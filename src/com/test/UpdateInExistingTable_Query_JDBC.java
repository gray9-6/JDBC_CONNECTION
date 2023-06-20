package com.test;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateInExistingTable_Query_JDBC {
    public static void main(String[] args) {
        try{
            // created a connection with database
            Connection connection = LargeImageConnectionProvider.getConnection();

            // Write a query
            String q = "update table1 set tName=?, tCity = ? where tId = ?";

            // taking user input
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter new Name");
            String name = bufferedReader.readLine();

            System.out.println("Enter new City ");
            String city = bufferedReader.readLine();

            System.out.println("Enter the student id whose data you want to update :");
            int id = Integer.parseInt(bufferedReader.readLine());

            // Making a statement
            PreparedStatement preparedStatement = connection.prepareStatement(q);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,city);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();

            // check for sucess
            System.out.println("Database Updated");

        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
