module edu.shadowauction.shadowauction {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires javax.websocket.api;
    requires tyrus.server;
    requires tyrus.client;

    opens edu.shadowauction.shadowauction to javafx.fxml;
    exports edu.shadowauction.shadowauction;
    exports edu.shadowauction.shadowauction.server;
}