package org.juannn.lockit.aplication.core.domain.port.out;

import org.juannn.lockit.aplication.core.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserPersistencePort {
    User saveUser(User user);
    Optional<User> getUserById(UUID id);
    void updateUser(User user);
    void deleteUser(UUID id);
    Optional<User> findByEmail(String email);
    List<User> findAll();

}