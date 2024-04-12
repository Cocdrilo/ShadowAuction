package com.mysqlconnection;

import edu.shadowauction.shadowauction.Usuario;
import javafx.scene.input.Dragboard;

import java.sql.*;

public class JDBC {

    public static String url_db = "jdbc:mysql://localhost:3306/sadb_schema";
    public static String user_db = "root";
    public static String password_db= "240103";

    public static boolean register(String username, String lastname, String email, String userpassword){
        try{

            if(!checkUser(username)){
                Connection connection = DriverManager.getConnection(url_db, user_db, password_db);

                PreparedStatement insertUser = connection.prepareStatement(
                        "INSERT INTO USERS(username, lastname, email, password) VALUES(?,?,?,?)"
                );

                insertUser.setString(1, username);
                insertUser.setString(2, lastname);
                insertUser.setString(3, email);
                insertUser.setString(4, userpassword);

                insertUser.executeUpdate();
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace(System.err);
        }
        return false;
    }

    public static boolean checkUser(String email){
        try {
            Connection connection = DriverManager.getConnection(url_db,user_db,password_db);

            PreparedStatement checkUserExists = connection.prepareStatement(
                    "SELECT * FROM USERS WHERE EMAIL = ?"
            );
            checkUserExists.setString(1,email);

            ResultSet resultSet = checkUserExists.executeQuery();

            if(!resultSet.isBeforeFirst()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace(System.err);
        }

        return true;
    }

    public static boolean validateLogin(String email, String userpassword){
        try {
            Connection connection = DriverManager.getConnection(url_db,user_db,password_db);

            PreparedStatement validateUser = connection.prepareStatement(
                    "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?"
            );

            validateUser.setString(1,email);
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

    public static String getUser(String email) {
        try {
            Connection connection = DriverManager.getConnection(url_db, user_db, password_db);

            PreparedStatement getUser = connection.prepareStatement(
                    "SELECT * FROM USERS WHERE EMAIL = ?"
            );
            getUser.setString(1, email);

            ResultSet resultSet = getUser.executeQuery();

            if (resultSet.next()) {
                String username = resultSet.getString("username");
                return username;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return null;
    }
}