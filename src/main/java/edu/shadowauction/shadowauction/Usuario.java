package edu.shadowauction.shadowauction;

public class Usuario {
    private static Usuario instance = null;
    private String username;

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

    public void closeSession() {
        instance = null;
    }
}