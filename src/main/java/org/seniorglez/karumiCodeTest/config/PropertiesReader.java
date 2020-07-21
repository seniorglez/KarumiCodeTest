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
package org.seniorglez.karumiCodeTest.config;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * This class allows to access the configuration of the application stored on the config.properties file located under
 * the resources directory.
 */
public class PropertiesReader {

    private static PropertiesReader propertiesReader = null;
    private Properties properties;

    /**
     * @return The {@link PropertiesReader} object associated with the current application.
     */
    public static PropertiesReader instanciate() {
        if(propertiesReader == null) propertiesReader = new PropertiesReader();
        return  propertiesReader;
    }

    /**
     * Construct a new {@link PropertiesReader}
     */
    private PropertiesReader() {
        properties = new Properties();
        InputStreamReader inputStreamReader = new InputStreamReader(getClass().getResourceAsStream("/karumiCodeTest/config.properties"));
        try {
            properties.load(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the value associated with the given key.
     * @param key the key associated with one value.
     * @return the value associated.
     */
    public String getProerty(String key) {
        return properties.getProperty(key);
    }

}
