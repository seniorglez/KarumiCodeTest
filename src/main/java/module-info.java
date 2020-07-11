module KarumiCodeTest {
    requires javafx.controls;
    requires javafx.fxml;

    opens KarumiCodeTest to javafx.fxml;

    exports KarumiCodeTest;
}