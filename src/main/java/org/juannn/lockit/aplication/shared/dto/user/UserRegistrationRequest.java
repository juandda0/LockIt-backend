package org.juannn.lockit.aplication.shared.dto.user;

public record UserRegistrationRequest(
        String username,
        String email,
        String password
) {
}