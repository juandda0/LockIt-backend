package org.juannn.lockit.aplication.infrastructure.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.juannn.lockit.aplication.core.domain.port.in.user.AuthenticateUserPort;
import org.juannn.lockit.aplication.core.domain.port.in.user.RegisterUserPort;
import org.juannn.lockit.aplication.shared.dto.user.LoginRequest;
import org.juannn.lockit.aplication.shared.dto.user.TokenResponse;
import org.juannn.lockit.aplication.shared.dto.user.UserRegistrationRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegisterUserPort registerUser;
    private final AuthenticateUserPort authenticateUser;

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@RequestBody final UserRegistrationRequest request) {
        TokenResponse token = registerUser.register(request);
        return ResponseEntity.ok(token);
    }
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody final LoginRequest request) {
        TokenResponse token = authenticateUser.login(request);
        return ResponseEntity.ok(token);

    }

    @PostMapping("/refresh")
    public TokenResponse refresh(@RequestHeader(HttpHeaders.AUTHORIZATION) final String authHeader) {
        return null;
    }
}
