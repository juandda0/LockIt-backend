package org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.password;

import org.juannn.lockit.aplication.core.domain.model.Password;
import org.juannn.lockit.aplication.core.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PasswordRepository extends JpaRepository<PasswordJpaEntity, UUID> {
}
