package karumiCodeTest.services.login;

import javafx.concurrent.Task;

public class LoginTask extends Task<String> {

    @Override
    protected String call() throws Exception {
        return "tokenMocked123";
    }
}
