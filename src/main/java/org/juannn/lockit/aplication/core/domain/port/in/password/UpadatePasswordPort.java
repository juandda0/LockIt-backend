package org.juannn.lockit.aplication.core.domain.port.in.password;

import org.juannn.lockit.aplication.core.domain.model.Password;

import java.util.Optional;

public interface UpadatePasswordPort {
    void updatePassword(Password password);
}
