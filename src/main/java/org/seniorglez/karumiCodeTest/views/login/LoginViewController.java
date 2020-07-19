package org.seniorglez.karumiCodeTest.views.login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController implements Initializable, EmailFormatChecker {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    private LoginViewModel loginViewModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setDisable(true);
    }

    @FXML
    private void handleKeyReleased(KeyEvent keyEvent){
        loginButton.setDisable(!checkEmail(usernameField.getText()) || passwordField.getText().length()==0);
    }
}
