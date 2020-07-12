package karumiCodeTest.services.login;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class LoginService extends Service<String> {
    @Override
    protected Task<String> createTask() {
        return new LoginTask();
    }
}
