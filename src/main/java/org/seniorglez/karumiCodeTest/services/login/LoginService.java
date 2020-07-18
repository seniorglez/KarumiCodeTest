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
package org.seniorglez.karumiCodeTest.services.login;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.seniorglez.karumiCodeTest.model.Credentials;

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
