package org.juannn.lockit.aplication.core.domain.service;

import lombok.RequiredArgsConstructor;
import org.juannn.lockit.aplication.core.domain.model.Password;
import org.juannn.lockit.aplication.core.domain.port.in.password.*;
import org.juannn.lockit.aplication.core.domain.port.out.PasswordPersistencePort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class PasswordService implements CreatePasswordPort, DeletePasswordPort, GetPasswordPort, UpadatePasswordPort,
        GetAllPasswordPort {

    private final PasswordPersistencePort passwordPersistencePort;

    @Override
    public Password createPassword(Password password) {
        return passwordPersistencePort.savePassword(password);
    }

    @Override
    public void deletePassword(UUID passwordId) {
        passwordPersistencePort.deletePassword(passwordId);
    }

    @Override
    public Optional<Password> getPassword(UUID passwordId) {
        return passwordPersistencePort.getPasswordById(passwordId);
    }

    @Override
    public void updatePassword(Password password) {
        passwordPersistencePort.updatePassword(password);
    }

    @Override
    public List<Password> getAllPasswords() {
        return passwordPersistencePort.getAllPasswords();
    }
}
