package org.juannn.lockit.aplication.shared.dto.user;

public record LoginRequest(
        String email,
        String password
) {
}
