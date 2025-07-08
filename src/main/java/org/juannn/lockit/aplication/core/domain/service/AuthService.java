package org.juannn.lockit.aplication.core.domain.service;

import lombok.RequiredArgsConstructor;
import org.juannn.lockit.aplication.core.domain.model.Token;
import org.juannn.lockit.aplication.core.domain.model.User;
import org.juannn.lockit.aplication.core.domain.port.in.user.*;
import org.juannn.lockit.aplication.core.domain.port.out.TokenPersistencePort;
import org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.user.UserRepository;
import org.juannn.lockit.aplication.shared.dto.user.LoginRequest;
import org.juannn.lockit.aplication.shared.dto.user.TokenResponse;
import org.juannn.lockit.aplication.shared.dto.user.UserRegistrationRequest;
import org.juannn.lockit.aplication.shared.mapper.UserMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthService implements RegisterUserPort, AuthenticateUserPort, RefreshTokenPort {

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final TokenPersistencePort tokenPersistencePort;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserServicePort userService;
    private final UserRepository userRepository;

    @Override
    public TokenResponse register(UserRegistrationRequest request) {
        User user = userMapper.toDomain(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var savedUser = userService.createUser(user);
        var jwtToken = jwtService.generateToken(savedUser);
        var refreshToken = jwtService.generateRefreshToken(savedUser);
        saveUserToken(savedUser, jwtToken);

        return new TokenResponse(jwtToken, refreshToken);
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = new Token(jwtToken, Token.TokenType.BEARER, false, false, user);
        tokenPersistencePort.saveToken(token);
    }

    @Override
    public TokenResponse login (LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var user = userService.findByEmail(request.email())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return new TokenResponse(jwtToken, refreshToken);
    }

    @Override
    public TokenResponse refreshToken(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("invalid Bearer token");
        }
        final String refreshToken = authHeader.substring(7);
        final String userEmail = jwtService.extractUsername(refreshToken);

        if(userEmail == null) {
            throw new IllegalArgumentException("Invalid Refresh Token");
        }

        final User user = userService.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException(userEmail));
        if(!jwtService.isTokenValid(refreshToken, user)){
            throw new IllegalArgumentException("invalid Refresh token");
        }

        final String accessToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, accessToken);

        return new TokenResponse(accessToken, refreshToken);
    }

    private void revokeAllUserTokens(final User user) {
        final List<Token> validUserTokens = tokenPersistencePort.findUsableTokensByUser(user.getId());
        if (!validUserTokens.isEmpty()) {
            for(final Token token : validUserTokens) {
                token.setExpired(true);
                token.setRevoked(true);
            }
            tokenPersistencePort.saveAll(validUserTokens);
        }
    }

}
