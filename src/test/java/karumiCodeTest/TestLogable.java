package karumiCodeTest;

import karumiCodeTest.config.PropertiesReader;
import karumiCodeTest.services.login.Loggable;
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

public class TestLogable implements Loggable {

    @Test
    public void shouldReturnAToken() throws IOException, InterruptedException, UnexpectedResponseCodeException {
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
        String s = logIn(httpClient,request,bodyHandlers);
        assertTrue("fakeToken" == s);
    }

    @Test
    public void shouldThrowAnUnexpectedResponseCodeException() throws IOException, InterruptedException {
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
            throw e;
        }
        Assertions.assertThrows(UnexpectedResponseCodeException.class, ()-> {
            logIn(httpClient,request,bodyHandlers);
        });
    }
}
