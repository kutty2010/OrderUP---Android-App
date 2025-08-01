package com.example.orderapli;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;  // Recommended for Serializable

    private final String username;
    private final String password;

    public User(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    // Consider security implications before adding getPassword()
    // If needed for serialization only, make it private
    private String getPassword() {
        return password;
    }


}