package org.juannn.lockit.aplication.core.domain.port.out;

import org.juannn.lockit.aplication.core.domain.model.Password;

import java.util.List;
import java.util.Optional;

public interface PasswordPersistencePort {
    Password savePassword(Password password);
    Optional<Password> getPasswordById(Long id);
    void updatePassword(Password password);
    void deletePassword(Long id);
    List<Password> getAllPasswords();
}
