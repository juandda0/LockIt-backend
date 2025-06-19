package org.juannn.lockit.aplication.core.domain.port.in.password;

import org.juannn.lockit.aplication.core.domain.model.Password;

import java.util.List;

public interface GetAllPasswordPort {
    List<Password> getAllPasswords();
}
