package edu.shadowauction.shadowauction.server;
import org.glassfish.tyrus.server.Server;
import java.util.Scanner;


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
        server = new Server("161.35.78.190", 8080, "/ws",null, AuctionServer.class);

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

    public static void main(String[] args) {
        WebSocketServerMain serverMain = WebSocketServerMain.getInstance();
        serverMain.startServer();

        // Mantén el servidor en ejecución hasta que se reciba una entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presiona Enter para detener el servidor...");
        scanner.nextLine();

        serverMain.stopServer();
    }

}

