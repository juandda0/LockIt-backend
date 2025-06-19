package org.juannn.lockit.aplication.core.domain.service;

import lombok.RequiredArgsConstructor;
import org.juannn.lockit.aplication.core.domain.model.User;
import org.juannn.lockit.aplication.core.domain.port.in.user.CreateUserPort;
import org.juannn.lockit.aplication.core.domain.port.in.user.DeleteUserPort;
import org.juannn.lockit.aplication.core.domain.port.in.user.GetUserPort;
import org.juannn.lockit.aplication.core.domain.port.in.user.UpdateUserPort;
import org.juannn.lockit.aplication.core.domain.port.out.UserPersistencePort;

import java.util.Optional;

@RequiredArgsConstructor
public class UserService implements CreateUserPort, DeleteUserPort, GetUserPort, UpdateUserPort {

    private final UserPersistencePort userPersistencePort;

    @Override
    public User create(User user) {
        return userPersistencePort.saveUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userPersistencePort.deleteUser(userId);
    }

    @Override
    public Optional<User> getUser(Long userId) {
        return userPersistencePort.getUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        userPersistencePort.updateUser(user);
    }

}
