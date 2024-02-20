package edu.shadowauction.shadowauction;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainController {
    @FXML
    private ImageView logoShadowAuction;

    //En JavaFX Initialize se llama siempre despues de crear el controlador.
    public void initialize() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> fadeIn()));
        timeline.play();
    }

    

    @FXML
    protected void fadeIn() {

        FadeTransition ft = new FadeTransition(Duration.seconds(2), logoShadowAuction);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }
}