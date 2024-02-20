module edu.shadowauction.shadowauction {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.kordamp.bootstrapfx.core;

    opens edu.shadowauction.shadowauction to javafx.fxml;
    exports edu.shadowauction.shadowauction;
}