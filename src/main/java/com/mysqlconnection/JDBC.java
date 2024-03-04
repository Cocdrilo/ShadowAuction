package com.mysqlconnection;

import javafx.scene.input.Dragboard;

import java.sql.*;

public class JDBC {

    public static String url_db = "jdbc:mysql://localhost:3306/sadb_schema";
    public static String user_db = "root";
    public static String password_db= "240103";

    public static boolean register(String username, String userpassword){
        try{

            if(!checkUser(username)){
                Connection connection = DriverManager.getConnection(url_db, user_db, password_db);

                PreparedStatement insertUser = connection.prepareStatement(
                        "INSERT INTO USERS(username, password) VALUES(?,?)"
                );

                insertUser.setString(1, username);
                insertUser.setString(2, userpassword);

                insertUser.executeUpdate();
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace(System.err);
        }
        return false;
    }

    public static boolean checkUser(String username){
        try {
            Connection connection = DriverManager.getConnection(url_db,user_db,password_db);

            PreparedStatement checkUserExists = connection.prepareStatement(
                    "SELECT * FROM USERS WHERE USERNAME = ?"
            );
            checkUserExists.setString(1,username);

            ResultSet resultSet = checkUserExists.executeQuery();

            if(!resultSet.isBeforeFirst()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace(System.err);
        }

        return true;
    }

    public static boolean validateLogin(String username, String userpassword){
        try {
            Connection connection = DriverManager.getConnection(url_db,user_db,password_db);

            PreparedStatement validateUser = connection.prepareStatement(
                    "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?"
            );

            validateUser.setString(1,username);
            validateUser.setString(2,userpassword);

            ResultSet resultSet = validateUser.executeQuery();

            if(!resultSet.isBeforeFirst()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace(System.err);
        }
        return true;
    }
}