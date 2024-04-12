package edu.shadowauction.shadowauction.server;
import javax.websocket.*;

@ClientEndpoint
public class AuctionClient {

    private String username; // Nuevo campo para guardar el nombre de usuario

    public void setUsername(String username) { // Método para establecer el nombre de usuario
        this.username = username;
    }
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Conexión abierta: " + session.getId()+", usuario: "+username);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Mensaje recibido: " + message);
        // Aquí puedes manejar el mensaje recibido según tus necesidades
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("Conexión cerrada: " + session.getId() + ", motivo: " + closeReason.getReasonPhrase());
    }

    @OnError
    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }
}