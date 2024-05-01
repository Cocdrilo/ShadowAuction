package edu.shadowauction.shadowauction;

public class Usuario {
    private static Usuario instance = null;
    private String username;

    private String email;
    private String password;

    private Usuario(String username) {
        this.username = username;
    }

    public static Usuario getInstance(String username) {
        if (instance == null) {
            instance = new Usuario(username);
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void closeSession() {
        instance = null;
    }
}