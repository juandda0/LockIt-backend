package org.juannn.lockit.aplication.core.domain.model;

import java.util.UUID;

public class Password {
    private UUID id;
    private String generatedPassword;
    private User user;

    public Password() {
    }

    public Password(UUID id, String generatedPassword) {
        this.id = id;
        this.generatedPassword = generatedPassword;
    }

    public Password(String generatedPassword, User user) {
        this.generatedPassword = generatedPassword;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGeneratedPassword() {
        return generatedPassword;
    }

    public void setGeneratedPassword(String generatedPassword) {
        this.generatedPassword = generatedPassword;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}