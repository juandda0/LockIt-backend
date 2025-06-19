package org.juannn.lockit.aplication.shared.dto.password;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

public class PasswordResponse {
    private UUID id;
    private String generatedPassword;

    public PasswordResponse() {
    }

    public PasswordResponse(UUID id, String generatedPassword) {
        this.id = id;
        this.generatedPassword = generatedPassword;
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
}
