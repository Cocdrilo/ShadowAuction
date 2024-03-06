package edu.shadowauction.shadowauction;

import com.mysqlconnection.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage mainStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.view.fxml"));
        Scene introScene = new Scene(fxmlLoader.load(), 800, 640);
        mainStage.setTitle("Shadow Auction");
        mainStage.setScene(introScene);
        mainStage.getIcons().add(new Image(new FileInputStream("src/main/resources/images/MiniLogo.PNG")));
        mainStage.show();
        mainStage.setMinHeight(605);
        mainStage.setMinWidth(804);
    }
    public static void main(String[] args) {


        //Checkea el registro para introducir datos en la DB
        System.out.println(JDBC.register("pepe", "fdez", "pepe@gmail.com", "password"));

        //Checkea la DB para saber si existe usuario con esos datos
        System.out.println(JDBC.validateLogin("paco@hotmail.com", "password"));

        launch();
    }
}