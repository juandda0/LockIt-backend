package org.juannn.lockit.aplication.core.domain.port.out;

import org.juannn.lockit.aplication.core.domain.model.Password;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PasswordPersistencePort {
    Password savePassword(Password password);
    Optional<Password> getPasswordById(UUID id);
    void updatePassword(Password password);
    void deletePassword(UUID id);
}
