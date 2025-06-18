package org.juannn.lockit.aplication.core.domain.port.out;

import org.juannn.lockit.aplication.core.domain.model.User;

import java.util.List;

public interface UserPersistencePort {
    public void saveUser(User user);
    public User getUserById(Long id);
    public void updateUser(User user);
    public void deleteUser(Long id);
    public List<User> getAllUsers();
}