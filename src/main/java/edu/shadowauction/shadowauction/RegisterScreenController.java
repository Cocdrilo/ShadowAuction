package edu.shadowauction.shadowauction;

import com.mysqlconnection.JDBC;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class RegisterScreenController {
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
    @FXML
    Label registerSuccesfulLabel;
    @FXML
    Hyperlink loginHyperlink;

    private FadeUtilityClass fader;

    public RegisterScreenController(){
        this.fader = new FadeUtilityClass();
    }

    public void registerButtonOnAction() throws IOException {
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
        JDBC.register(username, lastName, email, password);
        registerSuccesfulLabel.setText("User registered successfully");
        registerSuccesfulLabel.setOpacity(1);
        loginHyperlinkOnAction();
    }

    public boolean isValidUsernameLastName(String checkedField){
        if(checkedField.isEmpty()){
            registerErrorLabel.setText("Username field is empty");
            registerErrorLabel.setOpacity(1);
            return false;
        }
        return true;
    }

    public boolean isValidEmail(String email) {
        if (!email.contains("@")) {
            registerErrorLabel.setText("Email is invalid: missing @ symbol");
            registerErrorLabel.setOpacity(1);
            return false;
        }
        if (!email.contains(".")) {
            registerErrorLabel.setText("Email is invalid: missing dot (.)");
            registerErrorLabel.setOpacity(1);
            return false;
        }
        if (!email.matches("[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+")) {
            registerErrorLabel.setText("Email is invalid: incorrect format");
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

    public void loginHyperlinkOnAction() throws IOException {
        fader.fadeNextScene(rootPane,2,"Login.view.fxml");
    }




    
}
