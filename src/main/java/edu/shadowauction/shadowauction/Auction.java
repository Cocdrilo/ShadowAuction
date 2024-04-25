package edu.shadowauction.shadowauction;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Auction {
    private String nombre;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private ArrayList<Item> itemsFromAuction;

    public Auction(String nombre, LocalDateTime inicio, LocalDateTime fin, ArrayList<Item> itemsFromAuction) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        this.itemsFromAuction = itemsFromAuction;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public ArrayList<Item> getItemsFromAuction() {
        return itemsFromAuction;
    }
}
