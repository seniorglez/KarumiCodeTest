package org.seniorglez.karumiCodeTest.persistence;

import org.seniorglez.karumiCodeTest.config.PropertiesReader;

public class PersistenceHelperDesktop implements PersistenceHelper {

    private PropertiesReader propertiesReader;

    public PersistenceHelperDesktop() {
        propertiesReader = new PropertiesReader("/org/seniorglez/karumiCodeTest/userDefault/userDefaults.properties");
    }

    public String getSessionToken() {
        String token = propertiesReader.getProperty("token");
        return  (token.length()>0)? token : null;
    }

    public void setSessionToken(String value) {
        propertiesReader.setProperty("token", value);
    }

}
