package karumiCodeTest.services.login;

import javafx.concurrent.Task;
import karumiCodeTest.config.PropertiesReader;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class LoginTask extends Task<String> {

    String requestMethod;
    Map<String,String> parameters;

    public LoginTask() {

    }

    @Override
    protected String call() throws Exception {
        //return logIn();
        return "tokenMocked123";
    }

    private String logIn() throws UnexpectedResponseCodeException, IOException {
        URL url = new URL(PropertiesReader.instanciate().getProerty("url"));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(requestMethod);
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        addRequestParameters(con,parameters);
        StringBuffer response = readResponse(con);
        int status = con.getResponseCode();
        if (status < 200 || status > 299) throw new UnexpectedResponseCodeException("The http request response code was not included on the successful responses group (200-299)",status);
        return response.toString();

    }

    private void addRequestParameters(HttpURLConnection connection, Map<String,String> parameters) throws IOException {
        connection.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();
    }

    private StringBuffer readResponse(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content;
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