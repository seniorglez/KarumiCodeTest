package org.seniorglez.karumiCodeTest.model;

public class AppKey {
    private static AppKey instance;
    private String token;

    private AppKey() {

    }

    public static AppKey getInstance(){
        if(instance==null){
            instance = new AppKey();
        }
        return instance;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
