/* This file is part of KarumiCodeTest
 *
 *  Copyright (c) 2020 Diego Domínguez González
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 *  rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 *  and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial portions
 *  of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 *  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 *  IN THE SOFTWARE.
 */
package org.seniorglez.karumiCodeTest.views.login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.seniorglez.karumiCodeTest.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The view controller of the login view
 */
public class LoginViewController implements Initializable, EmailFormatChecker {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    /**
     * The ViewModel of this view
     */
    private LoginViewModel loginViewModel;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginViewModel = new LoginViewModel(this);
        loginButton.setDisable(true);
    }

    /**
     * Changes the current Stage scene for a scene generated with the given fxml.
     * @param fxml the name of the fxml (without the extension).
     */
    public void loadNewScene(String fxml){
        Stage stage = (Stage) this.loginButton.getScene().getWindow();
        System.out.println("Loading " + fxml);
        try {
            Scene scene = new Scene(App.loadFXML(fxml));
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles a {@link KeyEvent} when a key is released.
     * @param keyEvent the key event which is handled.
     */
    @FXML
    private void handleKeyReleased(KeyEvent keyEvent) {
        loginButton.setDisable(!checkEmail(usernameField.getText()) || passwordField.getText().length()==0);
    }

    /**
     * Handles the action of any JavaFX component but is built to handle the loginButton click.
     */
    @FXML
    private void handleButtonClicked() {
        loginViewModel.login(usernameField.getText(), passwordField.getText());
    }


}
