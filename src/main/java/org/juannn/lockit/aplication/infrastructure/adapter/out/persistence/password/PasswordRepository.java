package org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.password;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<PasswordJpaEntity, Long> {
}
