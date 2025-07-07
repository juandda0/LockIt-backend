package org.juannn.lockit.aplication.core.domain.model;

import java.util.UUID;

public class Password {
    private UUID id;
    private String generatedPassword;
    private String name;
    private User user;

    public Password() {
    }

    public Password(String generatedPassword, String name, User user) {
        this.generatedPassword = generatedPassword;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
