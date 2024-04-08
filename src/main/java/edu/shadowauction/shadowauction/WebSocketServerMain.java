package edu.shadowauction.shadowauction;
import org.glassfish.tyrus.server.Server;

public class WebSocketServerMain {
    private Server server;

    public void startServer() {
        server = new Server("localhost", 8080, "/ws", AuctionServer.class);

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