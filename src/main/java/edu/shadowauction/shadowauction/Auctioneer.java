package edu.shadowauction.shadowauction;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Auctioneer {

    private Image auctioneerImage;
    private ArrayList<String> frases;

    public Auctioneer(String imageURL) throws FileNotFoundException {
        frases = new ArrayList<String>();
        this.auctioneerImage = new Image(getClass().getResourceAsStream(imageURL));
        cargarFrases();
    }

    public Image getAuctioneerImage() {
        return auctioneerImage;
    }

    public void setAuctioneerImage(String imageURL) throws FileNotFoundException {
        this.auctioneerImage = new Image(getClass().getResourceAsStream(imageURL));
    }

    private void cargarFrases() {
        frases.add("¿Quién da más?");
        frases.add("¿Más ofertas?");
        frases.add("¡Es ahora!");
        frases.add("¿Quién se lo lleva?");
        frases.add("¡Más pujas!");
        frases.add("¡Competencia reñida!");
        frases.add("¡Tu momento!");
        frases.add("¡Oportunidad única!");
        frases.add("¡Merece más!");
        frases.add("¡Suba la puja!");
    }

    public String obtenerFraseAleatoria() {
        int indiceAleatorio = (int) (Math.random() * frases.size());
        return frases.get(indiceAleatorio);
    }
}
