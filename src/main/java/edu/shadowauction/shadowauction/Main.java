package edu.shadowauction.shadowauction;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage mainStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.view.fxml"));
        Scene introScene = new Scene(fxmlLoader.load(), 800, 640);
        mainStage.setTitle("Shadow Auction");
        mainStage.setScene(introScene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}