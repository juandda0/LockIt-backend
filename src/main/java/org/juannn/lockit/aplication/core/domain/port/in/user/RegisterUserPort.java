package org.juannn.lockit.aplication.core.domain.port.in.user;

import org.juannn.lockit.aplication.shared.dto.user.TokenResponse;
import org.juannn.lockit.aplication.shared.dto.user.UserRegistrationRequest;

public interface RegisterUserPort {
    TokenResponse register(UserRegistrationRequest request);
}
