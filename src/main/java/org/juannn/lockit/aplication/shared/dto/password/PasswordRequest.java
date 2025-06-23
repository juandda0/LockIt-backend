package org.juannn.lockit.aplication.shared.dto.password;

import java.util.UUID;

public class PasswordRequest {
    private UUID userId;

    public PasswordRequest() {
    }

    public PasswordRequest(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}