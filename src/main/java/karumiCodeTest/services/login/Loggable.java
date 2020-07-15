package karumiCodeTest.services.login;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Implementing this interface allows an object to preforms log in attempts on the server.
 */
public interface Loggable {

    /**
     * Preforms the log in attempt with the given {@link HttpClient}, {@link HttpRequest} and {@link java.net.http.HttpResponse.BodyHandler}.
     * It will return the token from the server unless an exception was thrown.
     * @param httpClient The {@link HttpClient} involved.
     * @param request The {@link HttpRequest}.
     * @param bodyHandler The {@link java.net.http.HttpResponse.BodyHandler}.
     * @return The session token.
     * @throws UnexpectedResponseCodeException An exception thrown when the status code is not a successful one.
     * @throws InterruptedException  An exception thrown when a thread is interrupted.
     * @throws IOException An exception produced by failed or interrupted I/O operations.
     */
    default String logIn(HttpClient httpClient, HttpRequest request, HttpResponse.BodyHandler<String> bodyHandler) throws UnexpectedResponseCodeException, InterruptedException, IOException {
        HttpResponse<String> response = httpClient.send(request, bodyHandler);
        int status = response.statusCode();
        if (status < 200 || status > 299)
            throw new UnexpectedResponseCodeException("The http request response code was not included on the successful responses group (200-299)", status);
        return response.body();
    }
}
