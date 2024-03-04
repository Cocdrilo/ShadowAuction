package edu.shadowauction.shadowauction;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import org.w3c.dom.Text;

public class LoginScreenController {
    @FXML
    StackPane rootPane;
    @FXML
    TextField usernameField;
    @FXML
    TextField emailField;
    @FXML
    TextField lastNameField;
    @FXML
    PasswordField passwordField;
    @FXML
    Label registerErrorLabel;

    public void registerButtonOnAction(){
        String username = usernameField.getText();
        if(!isValidUsernameLastName(username)){
            return;
        }

        String email = emailField.getText();
        if(!isValidEmail(email)){
            return;
        }

        String lastName = lastNameField.getText();
        if (!isValidUsernameLastName(lastName)){
            return;
        }

        String password = passwordField.getText();
        if(!checkPasswordSecurity(password)){
            return;
        }
        //If all checks passed register user
        System.out.println(username + " " + lastName + " " + email + " " + password);
        //JDBC.register(username, password);
    }

    public boolean isValidUsernameLastName(String checkedField){
        if(checkedField.isEmpty()){
            registerErrorLabel.setText("Username field is empty");
            registerErrorLabel.setOpacity(1);
            return false;
        }
        return true;
    }

    public boolean isValidEmail(String email){
        if(!email.contains("@") && !email.contains(".")){
            registerErrorLabel.setText("Email is invalid");
            registerErrorLabel.setOpacity(1);
            return false;
        }
        if(!email.matches("[a-zA-Z]+\\.")){
            registerErrorLabel.setText("Email must contain a letter before the dot");
            registerErrorLabel.setOpacity(1);
            return false;
        }
        return true;
    }
    public boolean checkPasswordSecurity(String passwordCheck){
        if(passwordCheck.length() < 8){
            registerErrorLabel.setText("Password is too short");
            registerErrorLabel.setOpacity(1);
            return false;
        }
        if(!passwordCheck.matches(".*[0-9].*")){
            registerErrorLabel.setText("Password must contain a number");
            registerErrorLabel.setOpacity(1);
            return false;
        }
        if(!passwordCheck.matches(".*[A-Z].*")){
            registerErrorLabel.setText("Password must contain an uppercase letter");
            registerErrorLabel.setOpacity(1);
            return false;
        }
        return true;
    }




    
}
