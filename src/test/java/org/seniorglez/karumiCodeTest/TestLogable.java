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
package org.seniorglez.karumiCodeTest;

import org.seniorglez.karumiCodeTest.services.login.Loggable;
import org.seniorglez.karumiCodeTest.services.login.UnexpectedResponseCodeException;
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
                .uri(URI.create("https://fakeURL.org/"))
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
    public void shouldThrowAnUnexpectedResponseCodeExceptionMore() throws IOException, InterruptedException {
        HttpClient httpClient = mock(HttpClient.class);
        HttpResponse mokedResponse = mock(HttpResponse.class);
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://fakeURL.org/"))
                .POST(HttpRequest.BodyPublishers.ofString("json"))
                .build();
        when(mokedResponse.statusCode()).thenReturn(300);
        when(mokedResponse.body()).thenReturn("fakeToken");
        HttpResponse.BodyHandler<String> bodyHandlers = HttpResponse.BodyHandlers.ofString();
        try {
            when(httpClient.send(request,bodyHandlers)).thenReturn(mokedResponse);
        } catch (IOException |InterruptedException e) {
            System.err.println("httpClientMockFailed");
            throw e;
        }
        Assertions.assertThrows(UnexpectedResponseCodeException.class, ()-> {
            logIn(httpClient, request, bodyHandlers);
        });
    }

    @Test
    public void shouldThrowAnUnexpectedResponseCodeExceptionLess() throws IOException, InterruptedException {
        HttpClient httpClient = mock(HttpClient.class);
        HttpResponse mokedResponse = mock(HttpResponse.class);
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://fakeURL.org/"))
                .POST(HttpRequest.BodyPublishers.ofString("json"))
                .build();
        when(mokedResponse.statusCode()).thenReturn(199);
        when(mokedResponse.body()).thenReturn("fakeToken");
        HttpResponse.BodyHandler<String> bodyHandlers = HttpResponse.BodyHandlers.ofString();
        try {
            when(httpClient.send(request,bodyHandlers)).thenReturn(mokedResponse);
        } catch (IOException |InterruptedException e) {
            System.err.println("httpClientMockFailed");
            throw e;
        }
        Assertions.assertThrows(UnexpectedResponseCodeException.class, ()-> {
            logIn(httpClient, request, bodyHandlers);
        });
    }
}
