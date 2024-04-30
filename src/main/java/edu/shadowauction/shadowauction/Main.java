package edu.shadowauction.shadowauction;

import com.mysqlconnection.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage mainStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Support.view.fxml"));
        Scene introScene = new Scene(fxmlLoader.load(), 800, 640);
        mainStage.setTitle("Shadow Auction");
        mainStage.setScene(introScene);
        mainStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/MiniLogo.png")));
        mainStage.show();
        mainStage.setMinHeight(605);
        mainStage.setMinWidth(804);
        mainStage.setResizable(false);
    }
    public static void main(String[] args) {
        launch();
    }
}