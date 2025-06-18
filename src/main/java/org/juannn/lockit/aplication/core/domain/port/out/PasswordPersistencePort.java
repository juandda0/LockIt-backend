package org.juannn.lockit.aplication.core.domain.port.out;

import org.juannn.lockit.aplication.core.domain.model.Password;

import java.util.List;

public interface PasswordPersistencePort {
    void savePassword(Password password);
    Password getPasswordById(Long id);
    void updatePassword(Password password);
    void deletePassword(Long id);
    List<Password> getAllPasswords();
}
