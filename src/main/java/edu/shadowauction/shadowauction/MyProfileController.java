package edu.shadowauction.shadowauction;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MyProfileController {

    @FXML
    public AnchorPane parentNode;
    @FXML
    public Button closeSessionButton;
    @FXML
    public Button modifyProfileButton;
    @FXML
    public TextField usernameLabel;
    @FXML
    public TextField emailLabel;
    @FXML
    public TextField passwordLabel;
    FadeUtilityClass fader;
    @FXML
    public Label errorLabel;

    public MyProfileController() {
        this.fader = new FadeUtilityClass();
    }
    public void initialize(){
        usernameLabel.setText(Usuario.getInstance(null,null).getUsername());
        emailLabel.setText(Usuario.getInstance(null,null).getEmail());
        passwordLabel.setText(Usuario.getInstance(null,null).getPassword());
    }

    @FXML
    public void goHomeIconOnAction() throws IOException {
        fader.fadeNextScene(parentNode, 2, "userMainMenu.view.fxml");
    }

    @FXML
    public void closeSessionButtonOnAction() throws IOException {
        Usuario.getInstance(null,null).closeSession();
        fader.fadeNextScene(parentNode, 2, "Main.view.fxml");
    }

    @FXML
    public void modifyProfileButtonOnAction() throws IOException {
        changeEditableOnFields(true);

        modifyProfileButton.setText("Save Changes");
        modifyProfileButton.setOnAction(e -> {
            try {
                saveChangesButtonOnAction();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

    }

    @FXML
    public void saveChangesButtonOnAction() throws IOException {
        String username = usernameLabel.getText();
        String email = emailLabel.getText();
        String password = passwordLabel.getText();


        if (!ValidationUtils.isValidUsername(username, errorLabel)) {
            return;
        }

        if (!ValidationUtils.isValidEmail(email, errorLabel) || !ValidationUtils.emailAlreadyRegistered(email, errorLabel)) {
            return;
        }

        if (!ValidationUtils.checkPasswordSecurity(password, errorLabel)) {
            return;
        }

        else{
            changeEditableOnFields(false);
            System.out.println("Username: " + username + " Email: " + email + " Password: " + password);
            modifyProfileButton.setText("Modify Profile");
            modifyProfileButton.setOnAction(e -> {
                try {
                    modifyProfileButtonOnAction();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }

    }



    public void changeEditableOnFields(boolean editable) {
        usernameLabel.setEditable(editable);
        emailLabel.setEditable(editable);
        passwordLabel.setEditable(editable);
    }

    @FXML
    public Label homeMessage = new Label();
    @FXML
    public void handleMouseEnterHome() {
        // Lógica para cuando el ratón entra en el ImageView
        homeMessage.setOpacity(1.0);
    }

    @FXML
    public void handleMouseExitHome() {
        // Lógica para cuando el ratón sale del ImageView
        homeMessage.setOpacity(0.0);
    }

}
