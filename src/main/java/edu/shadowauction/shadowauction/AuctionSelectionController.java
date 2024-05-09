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

    private ArrayList<Auction> subastas;


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


    public void initialize() throws Exception {
        this.testItems = new ArrayList<Item>();
        username.setText(Usuario.getInstance(null,null).getUsername());
        testItems.add(new Item("Contra", "Juego Matamarcianos de tipo run and gun inspirados en películas como Rambo o Alien. ",new Image(getClass().getResourceAsStream("/images/Contra.png")),40,0));
        testItems.add(new Item("Doom clasico", "Clasico juego que cualquiera a jugado hasta en su frigorifico ahora en cartucho clasico ",new Image(getClass().getResourceAsStream("/images/doom.png")),50,0));
        testItems.add(new Item("Mario Atari", "Clasico juego de mario hecho para la consola Atari ahora en su cartucho clasico ",new Image(getClass().getResourceAsStream("/images/MarioAtari.png")),50,0));
        testItems.add(new Item("Valis", "Clasico juego japones para la consola Atari ahora en su cartucho original ",new Image(getClass().getResourceAsStream("/images/Valis.png")),60,0));
        testItems.add(new Item("GreedIsland", "Una de las pocas copias de GreedIsland solo para usuarios preparados no devolvemos dinero en caso de muerte ",new Image(getClass().getResourceAsStream("/images/GreedIsland.png")),1000,0));
        test();

    }

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


    private void test(){
        // Inicializar la lista de subastas
        subastas = new ArrayList<>();
        subastas.add(new Auction("Subasta De Juegos Retro", LocalDateTime.of(2024, 4, 11, 10, 0),LocalDateTime.of(2024, 4, 11, 12, 0),testItems));
        // Crear un VBox para contener los botones de subasta
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefWidth(552);
        vbox.setPrefHeight(452);
        vbox.setBackground(new Background(new BackgroundFill(Color.rgb(96,23,140), null, null)));
        //vbox.setPrefHeight(443);

        // Agregar un botón para cada subasta
        for (Auction subasta : subastas) {
            String buttonText = subasta.getNombre() + " - Inicio: " + subasta.getInicio();
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
