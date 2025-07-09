package org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.jwt;

import org.juannn.lockit.aplication.core.domain.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface TokenRepository extends JpaRepository<TokenJpaEntity, Long> {
    List<TokenJpaEntity> findAllValidIsFalseOrRevokedIsFalseByUserId(UUID userId);

    @Query("SELECT t FROM tokens t LEFT JOIN FETCH t.user WHERE t.token = :token")
    Optional<TokenJpaEntity> findByToken(@Param("token") String token);
}
