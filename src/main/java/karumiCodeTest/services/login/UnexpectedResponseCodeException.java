/* This file is part of KarumiCodeTest
 *
 *  Copyright (c) 2020 Diego Domínguez González
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 *  rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 *  and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial portions
 *  of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 *  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 *  IN THE SOFTWARE.
 */
package karumiCodeTest.services.login;

/**
 * This exception is thrown when an attempt is made to make a request to an http API and the response code is none
 * of the expected ones.
 */
public class UnexpectedResponseCodeException extends Exception {

    /**
     * The http response code which provoked the {@link UnexpectedResponseCodeException}
     */
    private int responseCode;

    /**
     * Constucts a new {@link UnexpectedResponseCodeException} from the
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
