package edu.shadowauction.shadowauction;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainController {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView logoShadowAuction;

    @FXML
    protected void onHelloButtonClick() {

        FadeTransition ft = new FadeTransition(Duration.seconds(2), logoShadowAuction);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }
}