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
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 *  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 *  IN THE SOFTWARE.
 */
package org.seniorglez.karumiCodeTest.services.login;

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
