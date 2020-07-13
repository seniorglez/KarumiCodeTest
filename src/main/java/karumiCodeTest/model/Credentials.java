package karumiCodeTest.model;

/**
 * This POJO class represents the user credentials.
 */
public class Credentials {

    /**
     * The user email which is stored on the server.
     */
    String email;
    /**
     * The user password which is stored on the server.
     */
    String password;

    /**
     * Returns the user email.
     * @return The user email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user email.
     * @param email The user email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the user password.
     * @return The user password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user password.
     * @param password The user password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
