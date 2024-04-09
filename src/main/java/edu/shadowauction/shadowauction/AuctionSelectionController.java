package edu.shadowauction.shadowauction;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AuctionSelectionController {
    @FXML
    private Button boton;

    @FXML
    private ScrollPane scrollPane;

    private ArrayList<String> test;


    @FXML
    private void onActionBotonTimer() {
        testScroll();
    }

    @FXML
    public void testScroll() {
        // Crear una lista de cadenas de ejemplo
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("String 1");
        stringList.add("String 2");
        stringList.add("String 3");
        stringList.add("String 4");
        stringList.add("String 5");
        stringList.add("String 6");
        stringList.add("String 7");
        stringList.add("String 8");
        stringList.add("String 9");
        stringList.add("String 10");

        // Crear un TextArea para mostrar las cadenas
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);

        // Agregar las cadenas al TextArea
        for (String str : stringList) {
            textArea.appendText(str + "\n");
        }

        // Crear un ScrollPane y agregar el TextArea
        scrollPane.setContent(textArea);

    }


}
