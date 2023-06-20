package com.test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImageSave_JDBC {

    public  void storeImageInDataBase(){
        try{

            // creating connection
            String url = "jdbc:mysql://localhost:3306/untilted";
            Connection connection = DriverManager.getConnection(url,"root","#@incorrect");


            // check karo connection bana hai ya nahi
            if(connection.isClosed()){
                System.out.println("connection is closed");
            } else{
                System.out.println("connection is created....");
            }

            // Making a query
            String q = "insert into images(pic) values(?)";

            PreparedStatement preparedStatement = connection.prepareStatement(q);
            FileInputStream fis = new FileInputStream("D:\\java project\\untitled\\src\\icon\\background.jpg");
            preparedStatement.setBinaryStream(1,fis,fis.available());

            System.out.println("Image setting done");


        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ImageSave_JDBC imageSaveJdbc = new ImageSave_JDBC();
        imageSaveJdbc.storeImageInDataBase();

    }
}
