package edu.shadowauction.shadowauction;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class AuctionClientTest {

    public static void main(String[] args) throws URISyntaxException, DeploymentException, IOException, InterruptedException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://localhost:8080/auction/";
        Session session = container.connectToServer(AuctionClient.class, new URI(uri));

        // Mensaje de prueba al servidor
        session.getBasicRemote().sendText("Mensaje de prueba desde el cliente");

        // Esperar 5 segundos antes de cerrar la conexión
        Thread.sleep(5000);

        // Cerrar la conexión
        session.close();
    }
}