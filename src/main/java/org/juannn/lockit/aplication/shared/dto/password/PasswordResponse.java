package org.juannn.lockit.aplication.shared.dto.password;

import java.util.UUID;

public record PasswordResponse (
        UUID id,
        String generatedPassword,
        String name
){
}
