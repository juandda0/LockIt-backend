package org.juannn.lockit.aplication.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Profile("!prod") // Activa esta configuración cuando el perfil NO sea 'prod'
public class NoSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilita CSRF para APIs REST
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll() // Permite todas las solicitudes sin autenticación
                );
        return http.build();
    }
}
