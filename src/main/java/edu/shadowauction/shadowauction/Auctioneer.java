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
        frases.add("¡Vamos! ¿Alguien supera esta oferta?");
        frases.add("¡El momento de la oportunidad es ahora!");
        frases.add("¿Quién se lleva este objeto a casa?");
        frases.add("¡Suban esas pujas, caballeros!");
        frases.add("¡La competencia está reñida!");
        frases.add("¡Este es su momento para brillar!");
        frases.add("¡No dejen escapar esta oportunidad única!");
        frases.add("¡Este objeto merece una puja aún mayor!");
        frases.add("¡Hagamos que la puja suba aún más!");
    }

    public String obtenerFraseAleatoria() {
        int indiceAleatorio = (int) (Math.random() * frases.size());
        return frases.get(indiceAleatorio);
    }
}
