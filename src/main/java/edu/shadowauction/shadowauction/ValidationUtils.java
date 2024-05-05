package edu.shadowauction.shadowauction;

import com.mysqlconnection.JDBC;
import javafx.scene.control.Label;

public class ValidationUtils {

    public static boolean isValidUsername(String username, Label errorLabel) {
        if (username.isEmpty()) {
            errorLabel.setText("Username field is empty");
            errorLabel.setOpacity(1);
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String email, Label errorLabel) {
        if (!email.contains("@")) {
            errorLabel.setText("Email is invalid: missing @ symbol");
            errorLabel.setOpacity(1);
            return false;
        }
        if (!email.contains(".")) {
            errorLabel.setText("Email is invalid: missing dot (.)");
            errorLabel.setOpacity(1);
            return false;
        }
        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            errorLabel.setText("Email is invalid: incorrect format");
            errorLabel.setOpacity(1);
            return false;
        }
        return true;
    }

    public static boolean emailAlreadyRegistered(String email, Label errorLabel) {
        if (JDBC.checkUser(email)) {
            errorLabel.setText("Email already registered");
            errorLabel.setOpacity(1);
            return false;
        }
        return true;
    }

    public static boolean checkPasswordSecurity(String password, Label errorLabel) {
        if (password.length() < 8) {
            errorLabel.setText("Password is too short");
            errorLabel.setOpacity(1);
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            errorLabel.setText("Password must contain a number");
            errorLabel.setOpacity(1);
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            errorLabel.setText("Password must contain an uppercase letter");
            errorLabel.setOpacity(1);
            return false;
        }
        return true;
    }
}