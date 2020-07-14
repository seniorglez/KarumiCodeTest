module KarumiCodeTest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires org.mockito;

    opens karumiCodeTest to javafx.fxml;

    exports karumiCodeTest;
}