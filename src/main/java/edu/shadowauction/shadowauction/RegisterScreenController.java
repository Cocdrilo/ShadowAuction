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

    public RegisterScreenController() {
        this.fader = new FadeUtilityClass();
    }

    public void registerButtonOnAction() throws IOException {
        String username = usernameField.getText();
        if (!ValidationUtils.isValidUsername(username, registerErrorLabel)) {
            return;
        }

        String email = emailField.getText();
        if (!ValidationUtils.isValidEmail(email, registerErrorLabel) || !ValidationUtils.emailAlreadyRegistered(email, registerErrorLabel)) {
            return;
        }

        String lastName = lastNameField.getText();
        if (!ValidationUtils.isValidUsername(lastName, registerErrorLabel)) {
            return;
        }

        String password = passwordField.getText();
        if (!ValidationUtils.checkPasswordSecurity(password, registerErrorLabel)) {
            return;
        }

        //If all checks passed register user
        System.out.println(username + " " + lastName + " " + email + " " + password);
        JDBC.register(username, lastName, email, password);
        registerSuccesfulLabel.setText("User registered successfully");
        registerSuccesfulLabel.setOpacity(1);
        loginHyperlinkOnAction();
    }

    public void loginHyperlinkOnAction() throws IOException {
        fader.fadeNextScene(rootPane, 2, "Login.view.fxml");
    }
}