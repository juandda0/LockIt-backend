package org.juannn.lockit.aplication.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Password {
    private Long id;
    private String generatedPassword;

    public Password() {
    }

    public Password(Long id, String generatedPassword) {
        this.id = id;
        this.generatedPassword = generatedPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGeneratedPassword() {
        return generatedPassword;
    }

    public void setGeneratedPassword(String generatedPassword) {
        this.generatedPassword = generatedPassword;
    }
}
