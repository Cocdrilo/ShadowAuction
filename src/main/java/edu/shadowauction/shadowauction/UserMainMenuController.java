package edu.shadowauction.shadowauction;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserMainMenuController {

    private FadeUtilityClass fader;
    @FXML
    public AnchorPane parentNode;
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
    public Button PrivacyPolicyButton;
    @FXML
    public ImageView goHomeIcon;

    public UserMainMenuController(){
        this.fader = new FadeUtilityClass();
    }


    @FXML
    public void auctionSelectionButtonOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"AuctionSelection.view.fxml");
    }
    @FXML
    public void uploadArticlesButtonOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"UploadArticles.view.fxml");
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


}
