package edu.shadowauction.shadowauction;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AuctionSelectionController {
    @FXML
    private Button boton;

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane parentNode;

    private ArrayList<String> test;

    @FXML
    private void onActionBotonTimer() {
        test();
    }
    private ArrayList<Auction> subastas;
    @FXML
    private void test() {
        // Inicializar la lista de subastas
        subastas = new ArrayList<>();
        subastas.add(new Auction("Subasta 1", LocalDateTime.of(2024, 4, 11, 10, 0), LocalDateTime.of(2024, 4, 11, 12, 0)));
        subastas.add(new Auction("Subasta 2", LocalDateTime.of(2024, 4, 12, 15, 0), LocalDateTime.of(2024, 4, 12, 17, 0)));
        subastas.add(new Auction("Subasta 3", LocalDateTime.of(2024, 4, 13, 9, 0), LocalDateTime.of(2024, 4, 13, 11, 0)));
        subastas.add(new Auction("Subasta 4", LocalDateTime.of(2024, 4, 11, 10, 0), LocalDateTime.of(2024, 4, 11, 12, 0)));
        subastas.add(new Auction("Subasta 5", LocalDateTime.of(2024, 4, 12, 15, 0), LocalDateTime.of(2024, 4, 12, 17, 0)));
        subastas.add(new Auction("Subasta 6", LocalDateTime.of(2024, 4, 13, 9, 0), LocalDateTime.of(2024, 4, 13, 11, 0)));
        subastas.add(new Auction("Subasta 7", LocalDateTime.of(2024, 4, 11, 10, 0), LocalDateTime.of(2024, 4, 11, 12, 0)));
        subastas.add(new Auction("Subasta 8", LocalDateTime.of(2024, 4, 12, 15, 0), LocalDateTime.of(2024, 4, 12, 17, 0)));
        subastas.add(new Auction("Subasta 9", LocalDateTime.of(2024, 4, 13, 9, 0), LocalDateTime.of(2024, 4, 13, 11, 0)));
        subastas.add(new Auction("Subasta 10", LocalDateTime.of(2024, 4, 11, 10, 0), LocalDateTime.of(2024, 4, 11, 12, 0)));
        subastas.add(new Auction("Subasta 11", LocalDateTime.of(2024, 4, 12, 15, 0), LocalDateTime.of(2024, 4, 12, 17, 0)));
        subastas.add(new Auction("Subasta 12", LocalDateTime.of(2024, 4, 13, 9, 0), LocalDateTime.of(2024, 4, 13, 11, 0)));

        // Crear un VBox para contener los botones de subasta
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefWidth(540);
        vbox.setBackground(new Background(new BackgroundFill(Color.rgb(96,23,140), null, null)));
        //vbox.setPrefHeight(443);

        // Agregar un botón para cada subasta
        for (Auction subasta : subastas) {
            String buttonText = subasta.getNombre() + " - Inicio: " + subasta.getInicio() + " - Fin: " + subasta.getFin();
            Button button = new Button(buttonText);
            button.setPrefWidth(450);
            button.setPrefHeight(50);
            button.getStylesheets().add(getClass().getResource("/edu.shadowauction.css/AuctionSelectionStyleSheet.css").toExternalForm());
            button.getStyleClass().add("button");
            //button.setStyle("-fx-background-color: #BA49FE; -fx-font-size: 14px; -fx-text-fill: #000000;");
            button.setOnAction(event -> {
                // Realizar acciones según la subasta seleccionada
                System.out.println("Subasta seleccionada: " + subasta.getNombre());
                System.out.println("Inicio: " + subasta.getInicio());
                System.out.println("Fin: " + subasta.getFin());
            });
            vbox.getChildren().add(button);
        }

        // Crear un ScrollPane y agregar el VBox
        scrollPane.setContent(vbox);
    }
}
