package karumiCodeTest.services.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.concurrent.Task;
import karumiCodeTest.config.PropertiesReader;
import karumiCodeTest.model.Credentials;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * A Task which send the user credentials to the HTTP server and receives the response.
 */
public class LoginTask extends Task<String> {

    /**
     * The credentials of the user.
     */
    Credentials credentials;


    private HttpClient httpClient;

    private HttpRequest request;

    private HttpResponse.BodyHandler<String> bodyHandler;

    /**
     * Constructs a new {@link LoginTask} from the
     * specified credentials.
     * @param credentials The credentials of the user.
     */
    public LoginTask(Credentials credentials) {
        this.credentials = credentials;
    }

    /** 
     * Invoked when the Task is executed, tries to get the token from the server.
     * @return The response of the server.
     * @throws Exception An Exception thrown when attempting to communicate with the server.
     */
    @Override
    protected String call() throws Exception {
        prepareConnection();
        mockHttpClient();//Comment
        return logIn(httpClient,request, bodyHandler);
    }

    /**
     * Instances the members httpClient, request and bodyHandler
     * @throws JsonProcessingException An exception which is thrown by all the problems that may occur when parsing JSONs.
     */
    private void prepareConnection() throws JsonProcessingException {
        httpClient = HttpClient
                .newBuilder()
                .build();
        request = HttpRequest
                .newBuilder()
                .uri(URI.create(PropertiesReader.instanciate().getProerty("url")))
                .POST(HttpRequest.BodyPublishers.ofString(buildCredentialsJson()))
                .build();
        bodyHandler = HttpResponse.BodyHandlers.ofString();
    }

    /**
     * Mocks the httpClient to execute the app when the API is not available, please only use this method for demo proposes.
     * The http client and the response are mocked through the Mockito library.
     * @throws IOException
     * @throws InterruptedException
     */
    private void mockHttpClient() throws IOException, InterruptedException {
        httpClient = mock(HttpClient.class);
        HttpResponse mokedResponse = mock(HttpResponse.class);
        when(mokedResponse.statusCode()).thenReturn(200);
        when(mokedResponse.body()).thenReturn("fakeToken");
        try {
            when(httpClient.send(request, bodyHandler)).thenReturn(mokedResponse);
        } catch (IOException |InterruptedException e) {
            System.err.println("httpClientMockFailed");
            throw e;
        }
    }

    //logIn is public just to simplify the testing process, we have the encapsulation of the module anyway. But if will be a nice to have a library which allows us to test private methods.
    /**
     * @return The session token from the server.
     * @throws UnexpectedResponseCodeException
     * @throws InterruptedException
     * @throws IOException
     */
    public String logIn(HttpClient httpClient, HttpRequest request, HttpResponse.BodyHandler<String> bodyHandler) throws UnexpectedResponseCodeException, InterruptedException, IOException {
        HttpResponse<String> response = httpClient.send(request, bodyHandler);
        int status = response.statusCode();
        if (status < 200 || status > 299)
            throw new UnexpectedResponseCodeException("The http request response code was not included on the successful responses group (200-299)", status);
        return response.body();
    }

    /**
     * Parses the stored {@link Credentials} object to a JSON String.
     * @return The JSON String.
     * @throws JsonProcessingException An exception which is thrown by all the problems that may occur when parsing JSONs.
     */
    private String buildCredentialsJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(credentials);
    }
}
/*
Why I build a custom Exception for this task?

First and foremost the aim of this Exception is to be unchecked. The reason is because when the http response fails we will
want to show a message to the user explaining what just happen. The idea of the task is that when an exception is thrown
the task fails. Then we can just add a ChangeListener to the exceptionProperty of the LoginService instance, cast the
newValue to owr UnexpectedResponseCodeException (if we can) and show the user an alert. For example:

loginService.exceptionProperty().addListener((observable, oldValue, newValue) ->  {
  if(newValue != null && newValue instanceof UnexpectedResponseCodeException) {
    UnexpectedResponseCodeException ex = (UnexpectedResponseCodeException) newValue;
    int responseCode = ex.getResponseCode();
    //switch with the commons error code, etc...
  }
});

You are actually forced to work like this because you can't interact with the UI out of the JavaFX execution thread.
 */