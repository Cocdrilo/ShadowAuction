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


    //En JavaFX Initialize se llama siempre después de crear el controlador.
    public void initialize() {
        playFadeInTimeline();
        playSwitchSceneTimeline();
    }

    private void playFadeInTimeline() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> fadeIn()));
        timeline.play();
    }

    private void playSwitchSceneTimeline() {
        Timeline switchSceneTimeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            try {
                fadeNextScene();
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
        }));
        switchSceneTimeline.play();
    }

    @FXML
    protected void fadeIn() {
        FadeTransition ft = new FadeTransition(Duration.seconds(2), logoShadowAuction);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

    @FXML
    protected void fadeNextScene() throws IOException {
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.seconds(2));
        ft.setNode(rootPane);
        ft.setFromValue(1);
        ft.setToValue(0.0);
        ft.setOnFinished((ActionEvent e) -> {
            try {
                loadNextScene();
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
            }
        });
        ft.play();
    }

    private void loadNextScene() throws IOException {
        Parent secondView;
        secondView = FXMLLoader.load(getClass().getResource("Disclaimer.view.fxml"));
        Scene newScene = new Scene(secondView, 800, 640);
        Stage curStage = (Stage) rootPane.getScene().getWindow();
        curStage.setScene(newScene);
    }
}