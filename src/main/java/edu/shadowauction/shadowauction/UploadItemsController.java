package edu.shadowauction.shadowauction;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class UploadItemsController {

    private FadeUtilityClass fader;
    private FileChooser fileChooser;

    @FXML
    public ImageView goHomeIcon;

    @FXML
    public AnchorPane parentNode;
    @FXML
    public Label username;

    @FXML
    public Button seleccionarImagenesButton;

    @FXML
    private ComboBox<String> tipoEnvioComboBox;

    @FXML
    private Spinner<Integer> precioMinimoSpinner;

    public UploadItemsController() {
        this.fader = new FadeUtilityClass();
        this.fileChooser = new FileChooser();
    }

    // Método para inicializar la interfaz gráfica y establecer las opciones de tipo de envío
    public void initialize() {
        username.setText(Usuario.getInstance(null,null).getUsername());
        // Agregar las opciones de tipo de envío al ComboBox
        tipoEnvioComboBox.getItems().addAll("Envío estándar", "Envío express", "Envío prioritario", "Recogida en tienda");

        // Seleccionar una opción por defecto
        tipoEnvioComboBox.getSelectionModel().selectFirst();

        // Configurar la fábrica de valores para el Spinner
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000, 10);
        precioMinimoSpinner.setValueFactory(valueFactory);
    }

    @FXML
    public void goHomeIconOnAction() throws IOException {
        fader.fadeNextScene(parentNode, 2, "userMainMenu.view.fxml");
    }

    @FXML
    private void onSelectImagesButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imágenes");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.gif")
        );
        Stage stage = (Stage) seleccionarImagenesButton.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        // Aquí puedes guardar el archivo seleccionado y manejarlo como desees
        if (selectedFile != null) {
            // Aquí puedes escribir código para guardar el archivo
            System.out.println("Imagen seleccionada: " + selectedFile.getAbsolutePath());
        }
    }

    @FXML
    private void onSelectTipoEnvio() {
        String tipoEnvioSeleccionado = tipoEnvioComboBox.getValue();
        System.out.println("Tipo de envío seleccionado: " + tipoEnvioSeleccionado);
        // Aquí puedes hacer algo con el tipo de envío seleccionado, como guardarlo en una variable o utilizarlo de alguna otra manera
    }

    @FXML
    private void onChangePrecioMinimo() {
        int precioMinimo = precioMinimoSpinner.getValue();
        // Aquí puedes hacer algo con el precio mínimo, como guardarlo en una variable o utilizarlo de alguna otra manera
        System.out.println("Precio mínimo seleccionado: " + precioMinimo);
    }
}