package org.juannn.lockit.aplication.core.domain.port.in.user;

import org.juannn.lockit.aplication.shared.dto.user.LoginRequest;
import org.juannn.lockit.aplication.shared.dto.user.TokenResponse;

public interface AuthenticateUserPort {
    TokenResponse login(LoginRequest request);
}
