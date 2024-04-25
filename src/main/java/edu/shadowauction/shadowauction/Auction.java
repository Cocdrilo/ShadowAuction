package edu.shadowauction.shadowauction;

import java.time.LocalDateTime;

public class Auction {
    private String nombre;
    private LocalDateTime inicio;
    private LocalDateTime fin;

    public Auction(String nombre, LocalDateTime inicio, LocalDateTime fin) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
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
}
