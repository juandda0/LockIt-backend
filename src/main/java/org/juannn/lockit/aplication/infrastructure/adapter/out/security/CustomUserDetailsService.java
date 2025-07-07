package org.juannn.lockit.aplication.infrastructure.adapter.out.security;

import lombok.RequiredArgsConstructor;
import org.juannn.lockit.aplication.core.domain.model.User;
import org.juannn.lockit.aplication.core.domain.port.in.user.FindByEmailPort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final FindByEmailPort findByEmailPort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByEmailPort.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return new CustomUserDetails(user);
    }
}
