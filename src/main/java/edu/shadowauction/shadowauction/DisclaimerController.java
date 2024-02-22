package edu.shadowauction.shadowauction;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;


public class DisclaimerController {

    @FXML
    private StackPane rootPane;


    public void initialize() {
        rootPane.setOpacity(0.0);
        makeFadeIn();
    }

    private void makeFadeIn() {
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.seconds(2));
        ft.setNode(rootPane);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }
}
