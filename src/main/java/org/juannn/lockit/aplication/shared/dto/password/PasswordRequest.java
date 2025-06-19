package org.juannn.lockit.aplication.shared.dto.password;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class PasswordRequest {
    private String generatedPassword;

    public PasswordRequest(String generatedPassword) {
        this.generatedPassword = generatedPassword;
    }

    public PasswordRequest() {
    }

    public String getGeneratedPassword() {
        return generatedPassword;
    }

    public void setGeneratedPassword(String generatedPassword) {
        this.generatedPassword = generatedPassword;
    }
}
