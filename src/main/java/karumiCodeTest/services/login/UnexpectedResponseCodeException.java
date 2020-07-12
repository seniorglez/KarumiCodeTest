package karumiCodeTest.services.login;

/**
 * This exception is thrown when an attempt is made to make a request to an http API and the response code is none
 * of the expected ones.
 */
public class UnexpectedResponseCodeException extends Exception {

    private int responseCode;

    /**
     * Constucts a new (@code UnexpectedResponseCodeException) from the
     * specified response code and exception detail message.
     * @param detail the detail message
     * @param code the HTTP response code from server
     */
    public UnexpectedResponseCodeException(String detail, int code) {
        super(detail);
        this.responseCode = code;
    }

    /**
     * Returns the http response code
     *
     * @return The http response code
     */
    public int getResponseCode() {
        return  responseCode;
    }

    /**
     * Returns a string explaining why the http request was unexpected
     *
     * @return  the reason string
     */
    public String getReason() {
        return super.getMessage();
    }

}
