package edu.shadowauction.shadowauction;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/auction/")
public class AuctionServer {

    private static final Set<Session> sessions = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        // Procesar la puja y determinar la puja más alta
        // ...

        // Enviar la puja más alta a todos los clientes
        for (Session s : sessions) {
            s.getBasicRemote().sendText("La puja más alta es: " + message);
        }
    }
}
