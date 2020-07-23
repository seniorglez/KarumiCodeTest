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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * This class allows to access the configuration of the application stored on the config.properties file located under
 * the resources directory.
 */
public class PropertiesReader {

    private Properties properties;

    /**
     * Construct a new {@link PropertiesReader}
     */
    public PropertiesReader() {
        properties = new Properties();
        InputStream inputStream = PropertiesReader.class.getResourceAsStream("/org/seniorglez/karumiCodeTest/config/config.properties");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        try {
            properties.load(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Construct a new {@link PropertiesReader} with the properties located on the given url.
     */
    public PropertiesReader(String url) {
        properties = new Properties();
        InputStream inputStream = PropertiesReader.class.getResourceAsStream(url);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

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
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key,value);
    }

}
