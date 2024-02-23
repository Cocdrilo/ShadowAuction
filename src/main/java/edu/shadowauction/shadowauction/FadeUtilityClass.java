package edu.shadowauction.shadowauction;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class FadeUtilityClass {

    protected void  fadeNextScene(Node parentNode,int durationInSeconds,String nameOfTheFXMLFile) throws IOException {
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.seconds(durationInSeconds));
        ft.setNode(parentNode);
        ft.setFromValue(1);
        ft.setToValue(0.0);
        ft.setOnFinished((ActionEvent e) -> {
            try {
                loadNextScene(nameOfTheFXMLFile,parentNode);
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
            }
        });
        ft.play();
    }

    private void loadNextScene(String nameOfTheFXMLFile,Node parentNode) throws IOException {
        Parent secondView;
        secondView = FXMLLoader.load(getClass().getResource(nameOfTheFXMLFile));
        Scene newScene = new Scene(secondView, 800, 640);
        Stage curStage = (Stage) parentNode.getScene().getWindow();
        curStage.setScene(newScene);
    }

    protected void fadeInImage(int durationInSeconds, ImageView imagenAFadear) {
        FadeTransition ft = new FadeTransition(Duration.seconds(durationInSeconds), imagenAFadear);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }
}
