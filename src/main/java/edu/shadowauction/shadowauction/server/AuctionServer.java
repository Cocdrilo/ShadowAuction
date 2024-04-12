package edu.shadowauction.shadowauction.server;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/auction/")
public class AuctionServer {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Conexión abierta: " + session.getId()+", usuario: "+session.getUserPrincipal().getName());
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
