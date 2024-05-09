package edu.shadowauction.shadowauction;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SupportController {

    @FXML
    public ImageView goHomeIcon;
    @FXML
    public AnchorPane myProfile;
    @FXML
    public AnchorPane parentNode;
    @FXML
    public Label username;

    private FadeUtilityClass fader;

    public SupportController(){
        this.fader = new FadeUtilityClass();
    }

    public void initialize(){
        username.setText(Usuario.getInstance(null,null).getUsername());
    }

    @FXML
    public void goHomeIconOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"userMainMenu.view.fxml");
    }
    @FXML
    public void myProfileOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"MyProfile.view.fxml");
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
