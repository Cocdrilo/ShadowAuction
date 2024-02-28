package com.mysqlconnection;

import javafx.scene.input.Dragboard;

import java.sql.*;

public class JDBC {

    public static String url = "jdbc:mysql://localhost:3306/sadb_schema";
    public static String user = "root";
    public static String password1= "240103";

    public static boolean register(String username, String password){
        try{
            Connection connection = DriverManager.getConnection(url, user, password1);

            PreparedStatement insertUser = connection.prepareStatement(
                    "INSERT INTO USERS(username, password) VALUES(?,?)"
            );

            insertUser.setString(1,username);
            insertUser.setString(2,password);

            insertUser.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}