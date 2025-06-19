package org.juannn.lockit.aplication.infrastructure.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.juannn.lockit.aplication.core.domain.model.User;
import org.juannn.lockit.aplication.core.domain.port.out.UserPersistencePort;
import org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.user.UserJpaEntity;
import org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.user.UserRepository;
import org.juannn.lockit.aplication.shared.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserJpaAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public User saveUser(User user) {
        UserJpaEntity jpaEntity = userMapper.toJpaEntity(user);
        UserJpaEntity savedEntity = userRepository.save(jpaEntity);
        return userMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        Optional<UserJpaEntity> jpaEentity = userRepository.findById(id);

        return jpaEentity.map(userMapper::toDomain);
    }

    @Override
    public void updateUser(User user) {
        UserJpaEntity jpaEntity = userMapper.toJpaEntity(user);
        userRepository.save(jpaEntity);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDomain)
                .collect(Collectors.toList());
    }
}
