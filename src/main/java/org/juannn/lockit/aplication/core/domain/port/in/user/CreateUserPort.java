package org.juannn.lockit.aplication.core.domain.port.in.user;

import org.juannn.lockit.aplication.core.domain.model.User;

public interface CreateUserPort {
    User create(User user);
}
