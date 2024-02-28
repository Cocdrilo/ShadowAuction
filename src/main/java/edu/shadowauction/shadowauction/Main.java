package edu.shadowauction.shadowauction;

import com.mysqlconnection.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 640);
        stage.setTitle("Shadow Auction");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        System.out.println(JDBC.register("username1234", "pasword"));

        launch();
    }
}