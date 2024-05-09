package edu.shadowauction.shadowauction;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserMainMenuController {

    private FadeUtilityClass fader;
    @FXML
    public AnchorPane parentNode;
    @FXML
    public Label username;
    @FXML
    public Button auctionSelectionButton;
    @FXML
    public Button uploadArticlesButton;
    @FXML
    public Button myArticlesButton;
    @FXML
    public Button myReceiptsButton;
    @FXML
    public Button adminSupportButton;
    @FXML
    public Button privacyPolicyButton;
    @FXML
    public ImageView goHomeIcon;
    @FXML
    public AnchorPane myProfile;

    public UserMainMenuController(){
        this.fader = new FadeUtilityClass();
    }

    public void initialize(){
        username.setText(Usuario.getInstance(null,null).getUsername());
    }

    @FXML
    public void auctionSelectionButtonOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"AuctionSelection.view.fxml");
    }
    @FXML
    public void uploadArticlesButtonOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"UploadItems.view.fxml");
    }
    @FXML
    public void myArticlesButtonOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"MyArticles.view.fxml");
    }
    @FXML
    public void myReceiptsButtonOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"Receipts.view.fxml");
    }
    @FXML
    public void adminSupportButtonOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"Support.view.fxml");
    }
    @FXML
    public void PrivacyPolicyButtonOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"Terms.view.fxml");
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
