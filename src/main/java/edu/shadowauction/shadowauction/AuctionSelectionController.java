package edu.shadowauction.shadowauction;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AuctionSelectionController {
    @FXML
    private Button boton;
    @FXML
    private Label username;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane parentNode;

    @FXML
    public ImageView goHomeIcon;
    @FXML
    public AnchorPane myProfile;
    private FadeUtilityClass fader;
    private ArrayList<String> test;
    private ArrayList<Item> testItems;


    public AuctionSelectionController(){
        this.fader = new FadeUtilityClass();
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
    private void onActionBotonTimer(){
        test();
    }

    public void initialize() throws Exception {
        this.testItems = new ArrayList<Item>();
        username.setText(Usuario.getInstance(null,null).getUsername());
        testItems.add(new Item("Cuadro Testeo", "Lorem Impsum est ",new Image(getClass().getResourceAsStream("/images/CuadroTest.png")),100,0));
        testItems.add(new Item("Cuadro Testeo 2", "Lorem Impsum est ",new Image(getClass().getResourceAsStream("/images/CuadroTest.png")),200,0));
        System.out.println(testItems.get(0).getName());
    }
    private ArrayList<Auction> subastas;

    public void createAuction(ArrayList<Item> itemsFromAuction){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Auction.view.fxml"));
            Parent root = fxmlLoader.load();

            AuctionController controller = fxmlLoader.getController();
            controller.setItemsToAuction(itemsFromAuction);

            Scene newScene = new Scene(root, 800, 640);
            Stage curStage = (Stage) parentNode.getScene().getWindow();
            curStage.setScene(newScene);

            // Resto del código para mostrar la vista...
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    @FXML
    private void test(){
        // Inicializar la lista de subastas
        subastas = new ArrayList<>();
        subastas.add(new Auction("Subasta 1", LocalDateTime.of(2024, 4, 11, 10, 0), LocalDateTime.of(2024, 4, 11, 12, 0),testItems));
        subastas.add(new Auction("Subasta 2", LocalDateTime.of(2024, 4, 12, 15, 0), LocalDateTime.of(2024, 4, 12, 17, 0),testItems));

        // Crear un VBox para contener los botones de subasta
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefWidth(550);
        vbox.setPrefHeight(452);
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
                createAuction(subasta.getItemsFromAuction());
            });
            vbox.getChildren().add(button);
        }

        // Crear un ScrollPane y agregar el VBox
        scrollPane.setContent(vbox);
    }
}
