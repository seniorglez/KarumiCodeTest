package org.seniorglez.karumiCodeTest.views.login;
import javafx.beans.property.SimpleStringProperty;
import org.seniorglez.karumiCodeTest.model.AppKey;
import org.seniorglez.karumiCodeTest.model.Credentials;
import org.seniorglez.karumiCodeTest.services.login.LoginService;

import java.security.Provider;

/**
 * The view model of the Login view, implemented MVVM as far as vanilla javaFX allows me.
 */
public class LoginViewModel {

    private LoginService loginService;

    private LoginViewController loginViewController;

    public LoginViewModel(LoginViewController loginViewController) {
        this.loginViewController = loginViewController;
        setUpLoginService();


    }
    private void setUpLoginService(){
        loginService = new LoginService();
        loginService.setOnSucceeded(workerStateEvent -> {
            String token = (String) workerStateEvent.getSource().getValue();
            System.out.println("service");
            loginViewController.loadNewScene("userPanel");
        });
        loginService.setOnFailed(workerStateEvent -> {
            workerStateEvent.getSource().getException().printStackTrace();
        });
    }

    public void login( String name, String password) {
        Credentials credentials = new Credentials();
        credentials.setEmail(name);
        credentials.setPassword(password);
        loginService.setCredentials(credentials);
        System.out.println("Starting Service");
        if(!loginService.isRunning()){
            if((loginService.getState().name()=="READY")) loginService.start();
            else loginService.restart();
        } else {
            System.out.println("Service already running");
        }
    }
}
