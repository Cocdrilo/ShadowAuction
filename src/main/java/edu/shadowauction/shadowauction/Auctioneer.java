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
        frases.add("¡Vamos, valiente! ¿Alguien supera esta oferta?");
        frases.add("¡El momento de la oportunidad es ahora!");
        frases.add("¿Algún interesado en llevarse este objeto a casa?");
        frases.add("¡Suban esas pujas, caballeros!");
        frases.add("¡La competencia está reñida!");
        frases.add("¡Este es su momento para brillar!");
        frases.add("¿Quién se lleva este tesoro a casa hoy?");
        frases.add("¡No dejen que se escape esta oportunidad única!");
        frases.add("¡Un objeto tan valioso merece una puja aún mayor!");
        frases.add("¡Hagamos que el valor de este objeto suba aún más!");
    }

    public String obtenerFraseAleatoria() {
        int indiceAleatorio = (int) (Math.random() * frases.size());
        return frases.get(indiceAleatorio);
    }
}
