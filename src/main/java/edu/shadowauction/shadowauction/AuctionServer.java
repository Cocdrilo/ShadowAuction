package edu.shadowauction.shadowauction;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/auction/")
public class AuctionServer {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Conexión abierta: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Mensaje recibido: " + message);
        // Aquí puedes manejar el mensaje recibido según tus necesidades
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Conexión cerrada: " + session.getId());
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }
}
