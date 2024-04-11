package edu.shadowauction.shadowauction;
import org.glassfish.tyrus.server.Server;

public class WebSocketServerMain {
    private static WebSocketServerMain instance;
    private Server server;

    private WebSocketServerMain() {
        // Constructor privado para prevenir la instanciación directa
    }

    public static WebSocketServerMain getInstance() {
        if (instance == null) {
            instance = new WebSocketServerMain();
        }
        return instance;
    }

    public void startServer() {
        server = new Server("161.35.78.190", 8080, "/ws", AuctionServer.class);

        try {
            server.start();
            System.out.println("Servidor WebSocket iniciado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        if (server != null) {
            server.stop();
        }
    }
}