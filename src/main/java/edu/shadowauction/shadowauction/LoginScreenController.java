package edu.shadowauction.shadowauction;

import com.mysqlconnection.JDBC;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class LoginScreenController {
    @FXML
    StackPane rootPane;
    @FXML
    TextField emailField;
    @FXML
    PasswordField passwordField;
    @FXML
    Label registerErrorLabel;
    @FXML
    Hyperlink loginHyperlink;

    private FadeUtilityClass fader;

    public LoginScreenController(){
        this.fader = new FadeUtilityClass();
    }

    public void signUpButtonOnAction(){

        String email = emailField.getText();
        String password = passwordField.getText();

        //Try to LogIn
        System.out.println(email + " " + password);
        //JDBC.validateLogin(email, password);
    }

    public void loginHyperlinkOnAction() throws IOException {
        fader.fadeNextScene(rootPane,1,"Register.view.fxml");
    }




    
}
