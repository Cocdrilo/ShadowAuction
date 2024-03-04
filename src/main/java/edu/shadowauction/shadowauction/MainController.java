package edu.shadowauction.shadowauction;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainController {

    @FXML
    private StackPane rootPane;

    @FXML
    private ImageView logoShadowAuction;
    private FadeUtilityClass fader;

    public MainController(){
        this.fader = new FadeUtilityClass();
    }


    //En JavaFX Initialize se llama siempre después de crear el controlador.
    public void initialize() {
        playFadeInTimeline();
        playSwitchSceneTimeline();
    }

    private void playFadeInTimeline() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> fader.fadeInImage(2,logoShadowAuction)));
        timeline.play();
    }

    private void playSwitchSceneTimeline() {
        Timeline switchSceneTimeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            try {
                fader.fadeNextScene(rootPane,2,"Disclaimer.view.fxml");
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
        }));
        switchSceneTimeline.play();
    }

}