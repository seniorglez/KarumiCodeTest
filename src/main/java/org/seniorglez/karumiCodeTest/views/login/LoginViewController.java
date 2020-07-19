package org.seniorglez.karumiCodeTest.views.login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
        loginViewModel = new LoginViewModel(this);
        loginButton.setDisable(true);
    }

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

    @FXML
    private void handleKeyReleased(KeyEvent keyEvent) {
        loginButton.setDisable(!checkEmail(usernameField.getText()) || passwordField.getText().length()==0);
    }

    @FXML
    private void handleButtonClicked() {
        loginViewModel.login(usernameField.getText(), passwordField.getText());
    }


}
