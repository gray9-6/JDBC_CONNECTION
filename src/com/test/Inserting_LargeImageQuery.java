package com.test;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Inserting_LargeImageQuery {
    public static void main(String[] args) {
        try {
            // creating connection
            Connection connection =  LargeImageConnectionProvider.getConnection();

            // inserting query
            String q = "insert into images(pic) values(?)";

            PreparedStatement preparedStatement = connection.prepareStatement(q);

            // Jfile chooser hamare liye ek dialog box open kar dega ,, or usse hum apni file choose kar sakte hai
            // parent mein humne null paas kiya hai , toh ye center mein open hoga
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showOpenDialog(null);

            // jo file humne select ki hai wo hum, file chooser ke get selected file se nikal lenge
            // or ussko file ke object mein store kar lenge
            File file = jFileChooser.getSelectedFile();

            // ab jab wo file aa gayi jisko humne choose ki thi ,,
            // toh ab hum usko read karnege file input stream ki help se
            FileInputStream fis = new FileInputStream(file);

            preparedStatement.setBinaryStream(1,fis,fis.available());

            preparedStatement.executeUpdate();


            JOptionPane.showMessageDialog(null,"Success");
//            System.out.println("Done");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
