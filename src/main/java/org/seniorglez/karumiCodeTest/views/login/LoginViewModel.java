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
package org.seniorglez.karumiCodeTest.views.login;

import org.seniorglez.karumiCodeTest.model.Credentials;
import org.seniorglez.karumiCodeTest.services.login.LoginService;

/**
 * The view model of the Login view, implemented MVVM as far as vanilla javaFX allows me.
 */
public class LoginViewModel {

    /**
     * The {@link LoginService} which the instance uses to log in the server.
     */
    private LoginService loginService;

    /**
     * The view controller which is involved with this view model.
     */
    private LoginViewController loginViewController;

    /**
     * Constructs a new {@link LoginViewModel} from the specified {@link LoginViewController}
     * @param loginViewController he view controller which is involved with this view model.
     */
    public LoginViewModel(LoginViewController loginViewController) {
        this.loginViewController = loginViewController;
        setUpLoginService();
    }

    /**
     * Sets up the instance's {@link LoginService} which is going to use to log in the server.
     *
     * It will handle the succeeded event and the failed event.
     */
    private void setUpLoginService() {
        loginService = new LoginService();
        loginService.setOnSucceeded(workerStateEvent -> {
            String token = (String) workerStateEvent.getSource().getValue();
            loginViewController.loadNewScene("userPanel");
        });
        loginService.setOnFailed(workerStateEvent -> {
            workerStateEvent.getSource().getException().printStackTrace();//Here you can handle the UnexpectedResponseCodeException
        });
    }

    /**
     * Attempts to log in the server with a given name and a given password.
     * @param name The user's email
     * @param password The user's password
     */
    public void login( String name, String password) {
        Credentials credentials = new Credentials();
        credentials.setEmail(name);
        credentials.setPassword(password);
        loginService.setCredentials(credentials);
        System.out.println("Starting Service");
        if(!loginService.isRunning()){
            if((loginService.getState().name()=="READY")) loginService.start();
            else loginService.restart();
        } else {
            System.out.println("Service already running");
        }
    }
}
