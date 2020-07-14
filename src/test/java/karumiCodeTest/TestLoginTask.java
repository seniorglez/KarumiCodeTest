package karumiCodeTest;

import karumiCodeTest.config.PropertiesReader;
import karumiCodeTest.model.Credentials;
import karumiCodeTest.services.login.LoginTask;
import karumiCodeTest.services.login.UnexpectedResponseCodeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestLoginTask {

    @Test
    public void shouldReturnAToken() throws IOException, InterruptedException, UnexpectedResponseCodeException {
        Credentials credentials = new Credentials();
        LoginTask loginTask = new LoginTask(credentials);
        HttpClient httpClient = mock(HttpClient.class);
        HttpResponse mokedResponse = mock(HttpResponse.class);
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(PropertiesReader.instanciate().getProerty("url")))
                .POST(HttpRequest.BodyPublishers.ofString("json"))
                .build();
        when(mokedResponse.statusCode()).thenReturn(200);
        when(mokedResponse.body()).thenReturn("fakeToken");
        HttpResponse.BodyHandler<String> bodyHandlers = HttpResponse.BodyHandlers.ofString();
        try {
            when(httpClient.send(request,bodyHandlers)).thenReturn(mokedResponse);
        } catch (IOException |InterruptedException e) {
            System.err.println("httpClientMockFailed");
            throw e;
        }
        String s = loginTask.logIn(httpClient,request,bodyHandlers);
        assertTrue("fakeToken" == s);
    }

    @Test
    public void shouldThrowAnUnexpectedResponseException() {
        Credentials credentials = new Credentials();
        LoginTask loginTask = new LoginTask(credentials);
        HttpClient httpClient = mock(HttpClient.class);
        HttpResponse mokedResponse = mock(HttpResponse.class);
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(PropertiesReader.instanciate().getProerty("url")))
                .POST(HttpRequest.BodyPublishers.ofString("json"))
                .build();
        when(mokedResponse.statusCode()).thenReturn(404);
        when(mokedResponse.body()).thenReturn("fakeToken");
        HttpResponse.BodyHandler<String> bodyHandlers = HttpResponse.BodyHandlers.ofString();
        try {
            when(httpClient.send(request,bodyHandlers)).thenReturn(mokedResponse);
        } catch (IOException |InterruptedException e) {
            System.err.println("httpClientMockFailed");
        }
        Assertions.assertThrows(UnexpectedResponseCodeException.class, ()-> {
            loginTask.logIn(httpClient,request,bodyHandlers);
        });
    }
}
