package edu.shadowauction.shadowauction;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class ReceiptsController {

    @FXML
    public ImageView goHomeIcon;
    @FXML
    public AnchorPane myProfile;
    @FXML
    public AnchorPane parentNode;
    @FXML
    public Label username;
    @FXML
    private AnchorPane receiptsPane;

    private FadeUtilityClass fader;

    public ReceiptsController(){
        this.fader = new FadeUtilityClass();
    }

    public void initialize(){
        username.setText(Usuario.getInstance(null,null).getUsername());
        loadReceipts();
    }

    @FXML
    public void goHomeIconOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"userMainMenu.view.fxml");
    }
    @FXML
    public void myProfileOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"MyProfile.view.fxml");
    }

    private void loadReceipts() {
        // Load receipts (Fake it From Database)
        Label receipt1 = new Label("Cuadro Bonito - 100€");
        Label receipt2 = new Label("Cuadro Feo - 50€");
        Label receipt3 = new Label("Cita con Vicente + 0€ Oferta especial");
        ArrayList<Label> receipts = new ArrayList<>();
        receipts.add(receipt1);
        receipts.add(receipt2);
        receipts.add(receipt3);
        addReceiptsToPane(receipts);
    }

    private void addReceiptsToPane(ArrayList<Label> receipts) {
        VBox vbox = new VBox();
        vbox.setSpacing(10); // Espacio entre los recibos

        for (Label receipt : receipts) {
            if(receipt.getText().contains("+")){
                receipt.getStyleClass().add("receipt_green"); // Aplicar la clase CSS a cada recibo
            }
            else{
                receipt.getStyleClass().add("receipt_red"); // Aplicar la clase CSS a cada recibo
            }
            vbox.getChildren().add(receipt);
        }

        receiptsPane.getChildren().add(vbox);
    }

}