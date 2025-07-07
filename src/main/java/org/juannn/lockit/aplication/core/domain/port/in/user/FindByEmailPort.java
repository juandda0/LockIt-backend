package org.juannn.lockit.aplication.core.domain.port.in.user;

import org.juannn.lockit.aplication.core.domain.model.User;

import java.util.Optional;

public interface FindByEmailPort {
    Optional<User> findByEmail(String email);
}
