package org.juannn.lockit.aplication.core.domain.port.in.user;

import org.juannn.lockit.aplication.core.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface GetUserByIdPort {
    Optional<User> getUser(UUID userId);
}
