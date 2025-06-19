package org.juannn.lockit.aplication.core.domain.port.in.password;


import java.util.UUID;

public interface DeletePasswordPort {
    void deletePassword(UUID passwordId);
}
