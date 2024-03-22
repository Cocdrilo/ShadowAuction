package edu.shadowauction.shadowauction;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;


public class DisclaimerController {

    @FXML
    private StackPane rootPane;
    @FXML
    private Button acceptButton;
    @FXML
    private CheckBox termsAndConditionsCheckBox;
    @FXML
    private Label popUpAcceptTermsLabel;
    private FadeUtilityClass fader;

    public DisclaimerController(){
        this.fader = new FadeUtilityClass();
    }

    public void initialize() {
        rootPane.setOpacity(0.0);
        makeFadeIn();
        acceptTermsAndConditions();
    }

    private void makeFadeIn() {
        FadeTransition fadeInTransitioner = new FadeTransition();
        fadeInTransitioner.setDuration(Duration.seconds(2));
        fadeInTransitioner.setNode(rootPane);
        fadeInTransitioner.setFromValue(0);
        fadeInTransitioner.setToValue(1);
        fadeInTransitioner.play();
    }

    private void acceptTermsAndConditions(){
        acceptButton.setOnAction((ActionEvent event) -> {
            if (termsAndConditionsCheckBox.isSelected()) {
                try {
                    fader.fadeNextScene(rootPane,1,"Auction.view.fxml");
                } catch (IOException exceptionDuringFade) {
                    throw new RuntimeException(exceptionDuringFade);
                }
            } else {
                popUpAcceptTermsLabel.setText("Please accept terms and Conditions");
            }
        });
    }

}
