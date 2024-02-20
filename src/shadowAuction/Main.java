package shadowAuction;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("shadowAuction.fxml"));
        primaryStage.setTitle("Shadow Auction");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }
}