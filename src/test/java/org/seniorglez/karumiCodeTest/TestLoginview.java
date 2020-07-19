package org.seniorglez.karumiCodeTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;


import java.io.IOException;


@ExtendWith(ApplicationExtension.class)
public class TestLoginview {

    private Button button;

    @Start
    private void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/login/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param robot Will be injected by the test runner
     */
    @Test
    void testButtonTestShouldBeLogin(FxRobot robot) {
        FxAssert.verifyThat("#loginButton", LabeledMatchers.hasText("Login"));
    }
}
