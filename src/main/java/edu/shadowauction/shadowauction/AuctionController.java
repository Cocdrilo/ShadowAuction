package edu.shadowauction.shadowauction;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
    private Timeline timeline;
    private int seconds = 5 ;
    private int milliseconds = 0;

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
        String currentBidText = biggestBid.getText();
        int currentBid = extractAmount(currentBidText);
        int newBid = (int) Math.round(currentBid * 1.2);
        updateBidLabel(newBid);
    }

    @FXML
    private void onActionBotonX15() {
        String currentBidText = biggestBid.getText();
        int currentBid = extractAmount(currentBidText);
        int newBid = (int) Math.round(currentBid * 1.5);
        updateBidLabel(newBid);
    }

    @FXML
    private void onActionBotonX20() {
        String currentBidText = biggestBid.getText();
        int currentBid = extractAmount(currentBidText);
        int newBid = (int) Math.round(currentBid * 2);
        updateBidLabel(newBid);
    }

    private int extractAmount(String bidText) {
        // Remove the euro symbol and any non-numeric characters
        String amountString = bidText.replaceAll("[^\\d.]", "");
        return Integer.parseInt(amountString);
    }

    private void updateBidLabel(int newBid) {
        // Add euro symbol to the formatted bid and set it to the label
        biggestBid.setText(newBid + " €");
    }


    @FXML
    private void onActionBotonTimer(){
        auctioneerLabel.setText(genericAuctioneer.obtenerFraseAleatoria());
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
