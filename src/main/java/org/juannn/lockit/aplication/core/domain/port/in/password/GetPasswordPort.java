package org.juannn.lockit.aplication.core.domain.port.in.password;

import org.juannn.lockit.aplication.core.domain.model.Password;

import java.util.Optional;
import java.util.UUID;

public interface GetPasswordPort {
    Optional<Password> getPassword(UUID passwordId);
}