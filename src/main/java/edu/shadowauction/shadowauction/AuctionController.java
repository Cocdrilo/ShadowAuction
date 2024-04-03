package edu.shadowauction.shadowauction;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class AuctionController{

    private Auctioneer genericAuctioneer;
    @FXML
    private Button temporizador;
    @FXML
    private Button botonX12,botonX15,botonX20;
    @FXML
    private Label auctioneerLabel;
    @FXML
    private ImageView auctioneerImage;
    @FXML
    private Label biggestBid;
    @FXML
    private Label winnerBid;
    private Timeline timeline;
    private int seconds = 8 ;
    private int milliseconds = 0;
    //Necesario para que el temporizador no se ejecute varias veces a la vez
    private boolean timerRunning = false;
    private boolean bidEnded = false;

    public AuctionController() throws FileNotFoundException {
        this.genericAuctioneer = new Auctioneer("src/main/resources/images/christies-auction.jpg");
    }

    public void initialize() {
        showAuctioneerAfterFade();
    }

    private void showAuctioneerAfterFade() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), event -> auctioneerImage.setImage(genericAuctioneer.getAuctioneerImage())));
        timeline.play();
    }

    @FXML
    private void onActionBotonX12() {
        if(bidEnded){
            return;
        }
        String currentBidText = biggestBid.getText();
        int currentBid = extractAmount(currentBidText);
        int newBid = (int) Math.round(currentBid * 1.2);
        updateBidLabel(newBid);
        restartTimer();
    }

    @FXML
    private void onActionBotonX15() {
        if(bidEnded){
            return;
        }
        String currentBidText = biggestBid.getText();
        int currentBid = extractAmount(currentBidText);
        int newBid = (int) Math.round(currentBid * 1.5);
        updateBidLabel(newBid);
        restartTimer();
    }

    @FXML
    private void onActionBotonX20() {
        if(bidEnded){
            return;
        }
        String currentBidText = biggestBid.getText();
        int currentBid = extractAmount(currentBidText);
        int newBid = (int) Math.round(currentBid * 2);
        updateBidLabel(newBid);
        restartTimer();
    }

    private void restartTimer() {
        if (timerRunning) {
            timeline.stop();
            timerRunning = false;
        }
        seconds = 8;
        milliseconds = 0;
        temporizador.setText("08:00");
        startTimer();
        auctioneerLabel.setText(genericAuctioneer.obtenerFraseAleatoria());
    }

    private int extractAmount(String bidText) {
        // Remove the euro symbol and any non-numeric characters
        String amountString = bidText.replaceAll("[^\\d.]", "");
        return Integer.parseInt(amountString);
    }

    private void updateBidLabel(int newBid) {
        // Actualizar la etiqueta de la puja más alta y reiniciar el temporizador
        biggestBid.setText(newBid + " €");
    }


    @FXML
    private void onActionBotonTimer(){
        auctioneerLabel.setText(genericAuctioneer.obtenerFraseAleatoria());
        startTimer();
    }

    @FXML
    private void startTimer() {

        timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
            milliseconds -= 1;
            if (milliseconds < 0) {
                milliseconds = 99;
                seconds--;
            }
            if (seconds < 0) {
                timeline.stop();
                System.out.println("Tiempo terminado");
                winnerBid.setText("Winner of the bid is : " +" "+ biggestBid.getText());
                bidEnded = true;

            } else {
                temporizador.setText(String.format("%02d:%02d\n", seconds, milliseconds));
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        timerRunning = true;
    }

}
