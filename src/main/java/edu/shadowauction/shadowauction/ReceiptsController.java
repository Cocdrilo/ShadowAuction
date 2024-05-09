package edu.shadowauction.shadowauction;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public AnchorPane receiptsPane;

    private FadeUtilityClass fader;

    public ReceiptsController(){
        this.fader = new FadeUtilityClass();
    }

    public void initialize(){
        username.setText(Usuario.getInstance(null,null).getUsername());

        VBox vbox = addLabelsToVBox(createLabels());

        // Hacer que el VBox se ajuste al tamaño de su contenedor padre
        AnchorPane.setTopAnchor(vbox, 0.0);
        AnchorPane.setRightAnchor(vbox, 0.0);
        AnchorPane.setBottomAnchor(vbox, 0.0);
        AnchorPane.setLeftAnchor(vbox, 0.0);

        receiptsPane.getChildren().add(vbox);
    }

    @FXML
    public void goHomeIconOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"userMainMenu.view.fxml");
    }
    @FXML
    public void myProfileOnAction() throws IOException {
        fader.fadeNextScene(parentNode,2,"MyProfile.view.fxml");
    }

    @FXML
    public Label homeMessage = new Label();
    @FXML
    public void handleMouseEnterHome() {
        // Lógica para cuando el ratón entra en el ImageView
        homeMessage.setOpacity(1.0);
    }

    @FXML
    public void handleMouseExitHome() {
        // Lógica para cuando el ratón sale del ImageView
        homeMessage.setOpacity(0.0);
    }

    public List<Label> createLabels() {
        List<Label> labels = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            Label label = new Label("Texto aleatorio  +" + random.nextInt(100));
            labels.add(label);
        }

        return labels;
    }

    public VBox addLabelsToVBox(List<Label> labels) {
        VBox vbox = new VBox();

        for (Label label : labels) {
            String style = "-fx-font-size: 20; -fx-font-weight: bold;";

            if(label.getText().contains("+")){
                style += "-fx-text-fill: green;";
            }
            else{
                style += "-fx-text-fill: red;";
            }

            label.setStyle(style);
            vbox.getChildren().add(label);
        }

        return vbox;
    }


}