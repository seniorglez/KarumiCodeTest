package karumiCodeTest.services.login;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import karumiCodeTest.model.Credentials;

public class LoginService extends Service<String> {

    private Credentials credentials;

    @Override
    protected Task<String> createTask() {
        return new LoginTask(credentials);
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
