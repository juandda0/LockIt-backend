package org.juannn.lockit.aplication.shared.dto.password;

import java.util.UUID;

public record PasswordRequest (
        UUID userId,
        String name){
}