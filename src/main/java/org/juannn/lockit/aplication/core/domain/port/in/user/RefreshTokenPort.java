package org.juannn.lockit.aplication.core.domain.port.in.user;

import org.juannn.lockit.aplication.shared.dto.user.TokenResponse;

public interface RefreshTokenPort {
    TokenResponse refreshToken(String refreshToken);
}
