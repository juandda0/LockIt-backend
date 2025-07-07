package org.juannn.lockit.aplication.shared.dto.user;

import java.util.UUID;

public record UserRegistrationResponse(UUID id, String username, String email) {
}
