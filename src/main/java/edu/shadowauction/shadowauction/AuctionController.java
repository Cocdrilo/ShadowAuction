package edu.shadowauction.shadowauction;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
public class AuctionController{

    @FXML
    private Button temporizador;
    @FXML
    private Label labelTimer;
    @FXML
    private AnchorPane parentNode;
    private Timeline timeline;
    private int seconds = 5 ;
    private int milliseconds = 0;
    private Thread hilo;


    @FXML
    private void onActionBotonTimer(){
        start();
    }

    @FXML
    public void start() {
        timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                milliseconds -= 1;
                if (milliseconds < 0) {
                    milliseconds = 99;
                    seconds--;
                }
                if (seconds < 0) {
                    timeline.stop();
                    System.out.println("Tiempo terminado");
                } else {
                    temporizador.setText(String.format("%02d:%02d\n", seconds, milliseconds));
                }
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
