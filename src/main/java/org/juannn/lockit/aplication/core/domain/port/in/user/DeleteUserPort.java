package org.juannn.lockit.aplication.core.domain.port.in.user;

import java.util.UUID;

public interface DeleteUserPort {
    void deleteUser(UUID userId);
}
