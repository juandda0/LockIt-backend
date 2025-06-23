package org.juannn.lockit.aplication.core.configuration;

import org.juannn.lockit.aplication.core.domain.port.out.PasswordPersistencePort;
import org.juannn.lockit.aplication.core.domain.port.out.UserPersistencePort;
import org.juannn.lockit.aplication.core.domain.service.PasswordGeneratorService;
import org.juannn.lockit.aplication.core.domain.service.PasswordService;
import org.juannn.lockit.aplication.core.domain.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfigurator {

    @Bean
    public UserService userService(UserPersistencePort userPersistencePort) {
        return new UserService(userPersistencePort);
    }

    @Bean
    public PasswordService passwordService(PasswordPersistencePort passwordPersistencePort) {
        return new PasswordService(passwordPersistencePort);
    }
    @Bean
    public PasswordGeneratorService passwordGeneratorService() {
        return new PasswordGeneratorService();
    }

}
