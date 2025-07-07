package org.juannn.lockit.aplication.core.domain.port.out;

import org.juannn.lockit.aplication.core.domain.model.Token;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TokenPersistencePort {
    Token saveToken(Token token);
    Optional<Token> findByToken(String token);
    void revokeAllTokensByUserId(UUID userId);
    List<Token> findUsableTokensByUser(UUID userId);
    void saveAll(List<Token> tokens);

}