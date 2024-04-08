package edu.shadowauction.shadowauction;
import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class AuctionClient {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Conectado al servidor de subastas");
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Mensaje recibido del servidor: " + message);
    }
}