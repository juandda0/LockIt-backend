package org.juannn.lockit.aplication.core.domain.port.out;

import org.juannn.lockit.aplication.core.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserPersistencePort {
    User saveUser(User user);
    Optional<User> getUserById(Long id);
    void updateUser(User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
}