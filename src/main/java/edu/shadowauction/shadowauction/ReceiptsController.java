package edu.shadowauction.shadowauction;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ReceiptsController {

    @FXML
    public ImageView goHomeIcon;
    @FXML
    public AnchorPane myProfile;
    @FXML
    public AnchorPane parentNode;

    private FadeUtilityClass fader;

    public ReceiptsController(){
        this.fader = new FadeUtilityClass();
    }


    @FXML
    public void goHomeIconOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"userMainMenu.view.fxml");
    }
    @FXML
    public void myProfileOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"MyProfile.view.fxml");
    }

}