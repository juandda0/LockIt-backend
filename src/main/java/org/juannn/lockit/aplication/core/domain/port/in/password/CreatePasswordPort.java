    package org.juannn.lockit.aplication.core.domain.port.in.password;

    import org.juannn.lockit.aplication.core.domain.model.Password;

    public interface CreatePasswordPort {
        Password create(Password password);

    }
