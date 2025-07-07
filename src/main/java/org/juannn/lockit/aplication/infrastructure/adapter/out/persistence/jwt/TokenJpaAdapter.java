package org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.jwt;

import lombok.RequiredArgsConstructor;
import org.juannn.lockit.aplication.core.domain.model.Token;
import org.juannn.lockit.aplication.core.domain.port.out.TokenPersistencePort;
import org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.user.UserJpaEntity;
import org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.user.UserRepository;
import org.juannn.lockit.aplication.shared.mapper.TokenMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TokenJpaAdapter implements TokenPersistencePort {

    private final TokenRepository tokenRepository;
    private final TokenMapper tokenMapper;

    @Override
    public Token saveToken(Token token) {
        TokenJpaEntity jpa = tokenMapper.toJpaEntity(token);
        TokenJpaEntity saved = tokenRepository.save(jpa);
        return tokenMapper.toDomain(saved);
    }

    @Override
    public Optional<Token> findByToken(String token) {
        return null;
    }

    @Override
    public void revokeAllTokensByUserId(UUID userId) {
    }

    @Override
    public List<Token> findUsableTokensByUser(UUID userId) {
        List<TokenJpaEntity> validTokens = tokenRepository.findAllValidIsFalseOrRevokedIsFalseByUserId(userId);
        List<Token> tokens = validTokens.stream()
                .map(tokenMapper::toDomain)
                .collect(Collectors.toList());
        return tokens;
    }

    @Override
    public void saveAll(List<Token> tokens) {
        List<TokenJpaEntity> tokensSaved = tokens.stream()
                .map(tokenMapper::toJpaEntity)
                .collect(Collectors.toList());
        tokenRepository.saveAll(tokensSaved);
    }
}