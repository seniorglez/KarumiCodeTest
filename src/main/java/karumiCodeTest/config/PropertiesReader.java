package karumiCodeTest.config;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesReader {

    private static PropertiesReader propertiesReader = null;
    private Properties properties;

    public static PropertiesReader instanciate() {
        if(propertiesReader == null) propertiesReader = new PropertiesReader();
        return  propertiesReader;
    }

    private PropertiesReader() {
        properties = new Properties();
        InputStreamReader inputStreamReader = new InputStreamReader(getClass().getResourceAsStream("/karumiCodeTest/config.properties"));
        try {
            properties.load(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProerty(String key) {
        return properties.getProperty(key);
    }

}
