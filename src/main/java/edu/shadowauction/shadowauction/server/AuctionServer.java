package edu.shadowauction.shadowauction.server;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/auction/")
public class AuctionServer {
    private static Set<Session> clients = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Conexión abierta: " + session.getId());
        clients.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        //System.out.println("Mensaje recibido: " + message);
        // Retransmitir el mensaje a todos los clientes
        for (Session client : clients) {
            if(message.startsWith("LastBidder Update: ")){
                //Retransmite a todos todos independientemente de si no son los mismos
                client.getAsyncRemote().sendText(message);
            }
            else if (!client.equals(session)) {
                client.getAsyncRemote().sendText(message);
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Conexión cerrada: " + session.getId());
        clients.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }
}