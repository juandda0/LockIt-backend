package org.juannn.lockit.aplication.infrastructure.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.juannn.lockit.aplication.core.domain.model.Password;
import org.juannn.lockit.aplication.core.domain.port.out.PasswordPersistencePort;
import org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.password.PasswordJpaEntity;
import org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.password.PasswordRepository;
import org.juannn.lockit.aplication.shared.mapper.PasswordMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PasswordJpaAdapter implements PasswordPersistencePort {

    private final PasswordRepository passwordRepository;
    private final PasswordMapper passwordMapper;


    @Override
    public Password savePassword(Password password) {
        PasswordJpaEntity jpaEntity = passwordMapper.toJpaEntity(password);
        PasswordJpaEntity savedEntity = passwordRepository.save(jpaEntity);
        return passwordMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Password> getPasswordById(Long id) {
        Optional<PasswordJpaEntity> jpaEentity = passwordRepository.findById(id);
        return jpaEentity.map(passwordMapper::toDomain);
    }

    @Override
    public void updatePassword(Password password) {
        PasswordJpaEntity jpaEntity = passwordMapper.toJpaEntity(password);
        passwordRepository.save(jpaEntity);
    }

    @Override
    public void deletePassword(Long id) {
        passwordRepository.deleteById(id);
    }

    @Override
    public List<Password> getAllPasswords() {
        return passwordRepository.findAll().stream()
                .map(passwordMapper::toDomain)
                .collect(Collectors.toList());
    }
}
