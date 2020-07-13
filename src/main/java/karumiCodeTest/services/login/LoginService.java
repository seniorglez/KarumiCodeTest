package karumiCodeTest.services.login;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import karumiCodeTest.model.Credentials;

/**
 * A service which wraps the {@link LoginTask}.
 *
 * Before start the {@link LoginService} make sure that there is a {@link Credentials} object stored on the instance.
 */
public class LoginService extends Service<String> {

    /**
     * A object which represents the credentials used to log in the server.
     */
    private Credentials credentials;

    /**
     * Invoked after the service is started on the JavaFX Application Thread.
     * @return A {@link LoginTask} constructed with the {@link Credentials} object stored on the instance.
     */
    @Override
    protected Task<String> createTask() {
        return new LoginTask(credentials);
    }

    /** Set the {@link Credentials} object which is used to intanciate the LoginTask when the {@link LoginService} starts it's execution.
     * @param credentials the new credentials.
     */
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
