package org.juannn.lockit.aplication.core.domain.port.in.user;

import org.juannn.lockit.aplication.core.domain.model.User;

import java.util.List;

public interface GetAllUsersPort {
    List<User> findAll();

}
