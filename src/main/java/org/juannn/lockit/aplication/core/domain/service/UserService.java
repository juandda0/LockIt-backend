package org.juannn.lockit.aplication.core.domain.service;

import lombok.RequiredArgsConstructor;
import org.juannn.lockit.aplication.core.domain.model.User;
import org.juannn.lockit.aplication.core.domain.port.in.user.*;
import org.juannn.lockit.aplication.core.domain.port.out.UserPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService implements DeleteUserPort, UpdateUserPort, FindByEmailPort, GetUserByIdPort, CreateUserPort, GetAllUsersPort {

    private final UserPersistencePort userPersistencePort;

    @Override
    public void deleteUser(UUID userId) {
        userPersistencePort.deleteUser(userId);
    }

    @Override
    public Optional<User> getUser(UUID userId) {
        return userPersistencePort.getUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        userPersistencePort.updateUser(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userPersistencePort.findByEmail(email);
    }

    @Override
    public User createUser(User user) {
        return userPersistencePort.saveUser(user);
    }

    @Override
    public List<User> findAll() {
        return userPersistencePort.findAll();
    }
}
