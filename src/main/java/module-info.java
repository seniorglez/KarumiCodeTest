module KarumiCodeTest {
    requires javafx.controls;
    requires javafx.fxml;

    opens karumiCodeTest to javafx.fxml;

    exports karumiCodeTest;
}