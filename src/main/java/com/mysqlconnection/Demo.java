package com.mysqlconnection;

import javafx.scene.input.Dragboard;

import java.sql.*;

public class Demo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "240103";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection us Succesful to the database: " + url);
            Statement statement = connection.createStatement();
            //String query = "INSERT into student(idstudent,Name) values (2,'paco')";

            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

            while(resultSet.next()){
                System.out.println(resultSet.getString("idstudent") + " | " + resultSet.getString("Name"));
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }
}
