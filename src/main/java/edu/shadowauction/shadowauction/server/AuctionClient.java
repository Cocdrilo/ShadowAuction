package edu.shadowauction.shadowauction.server;
import edu.shadowauction.shadowauction.AuctionEventListener;

import javax.websocket.*;
import java.util.ArrayList;
import java.util.List;

@ClientEndpoint
public class AuctionClient {

    private String username; // Nuevo campo para guardar el nombre de usuario

    private static List<AuctionEventListener> listeners = new ArrayList<>();


    public static void addAuctionEventListener(AuctionEventListener listener) {
        listeners.add(listener);
    }


    public void setUsername(String username) { // Método para establecer el nombre de usuario
        this.username = username;
    }
    public String getUsername(){ // Método para obtener el nombre de usuario
        return this.username;
    }
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Conexión abierta: " + session.getId()+", usuario: "+username);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        //System.out.println("Mensaje recibido: " + message);
        if (message.startsWith("New bid: ")) {
            String bidString = message.substring(9);
            int newBid = Integer.parseInt(bidString);
            for (AuctionEventListener listener : listeners) {
                listener.onNewBid(newBid);
            }
        } else if (message.startsWith("Timer update: ")) {
            String timeString = message.substring(14);
            for (AuctionEventListener listener : listeners) {
                listener.onTimerUpdate(timeString);
            }
        } else if (message.startsWith("LastBidder Update: ")){
            String lastBidder = message.substring(19);
            System.out.println("Last bidder: " + lastBidder);
            for (AuctionEventListener listener : listeners) {
                listener.onLastBidderUpdate(lastBidder);
            }
        } else if(message.startsWith("Chat message From: ")){
            //Coge el usuario que es desde el 19 hasta cuando se encuentre un " "
            String username = message.substring(19, message.indexOf(" ", 19));
            String chatMessage = message.substring(19+username.length());
            for (AuctionEventListener listener : listeners) {
                listener.onChatMessage(chatMessage, username);
            }
        } else if(message.startsWith("Item Info: ")){
            for (AuctionEventListener listener : listeners) {
                listener.onChatMessage(message.substring(11), "Server");
            }
        }
        else{
            System.out.println("Mensaje recibido: " + message);
        }
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