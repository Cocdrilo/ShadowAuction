package edu.shadowauction.shadowauction.server;
import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

import edu.shadowauction.shadowauction.server.AuctionClient;
import org.glassfish.tyrus.client.ClientManager;

@ClientEndpoint
public class WebSocketClientTest {

    private static Session session;
    public static final String SERVER = "ws://161.35.78.190:8080/ws/auction/";

    public static void connectClient(AuctionClient client) throws Exception {
        ClientManager clientManager = ClientManager.createClient();
        session = clientManager.connectToServer(client, new URI(SERVER)); // Aquí se utiliza la variable session estática
        System.out.println("Client connected to server");
    }

    public static void sendMessage(AuctionClient client, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            System.err.println("Error al enviar mensaje: " + e.getMessage());
        }
    }

        public static void main(String[] args) throws Exception {
            ClientManager client = ClientManager.createClient();
            String message;

            // connect to server
            Scanner scanner = new Scanner(System.in);
            System.out.println("What's your name?");
            String user = scanner.nextLine();

            AuctionClient auctionClient = new AuctionClient();
            auctionClient.setUsername(user);

            Session session = client.connectToServer(auctionClient, new URI(SERVER));
            System.out.println("You are logged in as: " + user);

            // send messages to server
            while (true) {
                System.out.println("Type a message to send to the server or type 'exit' to close the connection:");
                message = scanner.nextLine();
                if (message.equalsIgnoreCase("exit")) {
                    session.close();
                    break;
                }
                session.getBasicRemote().sendText(user + ": " + message);
            }
        }

    }