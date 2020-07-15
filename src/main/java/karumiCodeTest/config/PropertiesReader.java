package karumiCodeTest.config;

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
