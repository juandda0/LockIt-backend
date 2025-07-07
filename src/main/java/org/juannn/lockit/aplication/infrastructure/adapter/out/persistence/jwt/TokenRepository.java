package org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.jwt;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface TokenRepository extends JpaRepository<TokenJpaEntity, Long> {
    List<TokenJpaEntity> findAllValidIsFalseOrRevokedIsFalseByUserId(UUID userId);
}
