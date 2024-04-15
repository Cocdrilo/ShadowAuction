package edu.shadowauction.shadowauction;
import edu.shadowauction.shadowauction.server.AuctionClient;
import edu.shadowauction.shadowauction.server.WebSocketClientTest;
import edu.shadowauction.shadowauction.server.WebSocketServerMain;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AuctionController implements AuctionEventListener {

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
    private Label errorLabel;
    private Timeline timeline;
    private int seconds = 8 ;
    private int milliseconds = 0;
    //Necesario para que el temporizador no se ejecute varias veces a la vez
    private boolean timerRunning = false;
    private WebSocketServerMain serverMain;
    private List<AuctionClient> clients; // Lista para almacenar los clientes conectados
    private String lastClientBidder = "";

    public AuctionController() throws FileNotFoundException {
        this.serverMain = WebSocketServerMain.getInstance();
        this.genericAuctioneer = new Auctioneer("/images/christies-auction.jpg");
        this.clients = new ArrayList<>();
    }

    public void initialize() throws Exception {
        showAuctioneerAfterFade();
        createClient();
    }


    public void createClient() throws Exception {
        AuctionClient client = new AuctionClient(); // Crear una nueva instancia de AuctionClient
        client.setUsername(Usuario.getInstance(null).getUsername()); // Establecer el nombre de usuario
        this.clients.add(client); // Agregar el cliente a la lista de clientes
        AuctionClient.addAuctionEventListener(this);
        WebSocketClientTest.connectClient(client); // Conectar el cliente al servidor
    }



    private void showAuctioneerAfterFade() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), event -> auctioneerImage.setImage(genericAuctioneer.getAuctioneerImage())));
        timeline.play();
    }

    @FXML
    private void onActionBotonX12() {
        if (sameUserBids()) return;
        String currentBidText = biggestBid.getText();
        int currentBid = extractAmount(currentBidText);
        int newBid = (int) Math.round(currentBid * 1.2);
        updateBidLabel(newBid);
        broadcastBidUpdate(newBid);
        restartTimer();
    }

    @FXML
    private void onActionBotonX15() {
        if (sameUserBids()){
            return;

        }
        String currentBidText = biggestBid.getText();
        int currentBid = extractAmount(currentBidText);
        int newBid = (int) Math.round(currentBid * 1.5);
        updateBidLabel(newBid);
        broadcastBidUpdate(newBid);
        restartTimer();
    }

    @FXML
    private void onActionBotonX20() {
        if (sameUserBids()) return;
        String currentBidText = biggestBid.getText();
        int currentBid = extractAmount(currentBidText);
        int newBid = (int) Math.round(currentBid * 2);
        updateBidLabel(newBid);
        broadcastBidUpdate(newBid);
        restartTimer();
    }

    public void broadcastBidUpdate(int newBid) {
        for (AuctionClient client : this.clients) {
            WebSocketClientTest.sendMessage(client, "New bid: " + newBid);
        }
    }


    private boolean sameUserBids() {
        if(Objects.equals(lastClientBidder, Usuario.getInstance(null).getUsername())) {
            System.out.println("No puedes pujar dos veces seguidas");
            errorLabel.setText("No puedes pujar dos veces seguidas");
            errorLabel.setOpacity(1);
            hideErrorLabelAfter2Seconds();
            return true;
        }
        updateLastClientBidder(lastClientBidder);
        return false;
    }

    private void updateLastClientBidder(String lastBidder) {
        for (AuctionClient client : this.clients) {
            WebSocketClientTest.sendMessage(client, "LastBidder Update: " + lastBidder);
        }
    }

    private void hideErrorLabelAfter2Seconds() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> errorLabel.setOpacity(0)));
        timeline.play();
    }

    @Override
    public void onNewBid(int newBid) {
        Platform.runLater(() -> {
            updateBidLabel(newBid);
        });
    }

    @Override
    public void onTimerUpdate(String timeString) {
        Platform.runLater(() -> {
            temporizador.setText(timeString);
        });
    }

    @Override
    public void onLastBidderUpdate(String lastBidder) {
        System.out.println("Last bidder: " + lastClientBidder);
        System.out.println("Last bidder: " + lastBidder);
        this.lastClientBidder = lastBidder;
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
                broadcastTimerUpdate("Tiempo terminado");
            } else {
                String timeString = String.format("%02d:%02d\n", seconds, milliseconds);
                temporizador.setText(timeString);
                broadcastTimerUpdate(timeString);
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        timerRunning = true;
    }

    public void broadcastTimerUpdate(String timeString) {
        for (AuctionClient client : this.clients) {
            WebSocketClientTest.sendMessage(client, "Timer update: " + timeString);
        }
    }

}
