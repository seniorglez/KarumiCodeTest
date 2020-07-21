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

package org.seniorglez.karumiCodeTest.model;

/**
 *  This class allows the app to store some keys needed to work with the API
 */
public class AppKey {

    /**
     * The instance of {@link AppKey} for the current session.
     */
    private static AppKey instance;

    /**
     *  The session token for this session.
     */
    private String token;

    private AppKey() {

    }

    /**
     * Returns the instance of {@link AppKey) for this session.
     * @return The instance of {@link AppKey) for this session.
     */
    public static AppKey getInstance(){
        if(instance==null){
            instance = new AppKey();
        }
        return instance;
    }

    /**
     * Returns the current token for this session.
     * @return The current token for this session.
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets a new value for the current session token.
     * @param token the new value of the current session token.
     */
    public void setToken(String token) {
        this.token = token;
    }
}
