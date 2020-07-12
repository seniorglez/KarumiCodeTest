package karumiCodeTest.services.login;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import karumiCodeTest.config.PropertiesReader;

public class LoginService extends Service<String> {

    private String apiUrl;

    public LoginService () {
        apiUrl = PropertiesReader.instanciate().getProerty("url");
    }

    @Override
    protected Task<String> createTask() {
        return new LoginTask();
    }
}
