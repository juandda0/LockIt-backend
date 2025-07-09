package org.juannn.lockit.aplication.infrastructure.adapter.in.web;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.juannn.lockit.aplication.core.domain.model.Password;
import org.juannn.lockit.aplication.core.domain.model.User;
import org.juannn.lockit.aplication.core.domain.port.in.password.CreatePasswordPort;
import org.juannn.lockit.aplication.core.domain.port.in.password.DeletePasswordPort;
import org.juannn.lockit.aplication.core.domain.port.out.UserPersistencePort;
import org.juannn.lockit.aplication.core.domain.service.PasswordGeneratorService;
import org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.user.UserRepository;
import org.juannn.lockit.aplication.shared.dto.password.PasswordRequest;
import org.juannn.lockit.aplication.shared.dto.password.PasswordResponse;
import org.juannn.lockit.aplication.shared.dto.user.UserRegistrationRequest;
import org.juannn.lockit.aplication.shared.dto.user.UserRegistrationResponse;
import org.juannn.lockit.aplication.shared.mapper.PasswordMapper;
import org.juannn.lockit.aplication.shared.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/passwords")
@RequiredArgsConstructor
@Slf4j
public class PasswordController {

    private final CreatePasswordPort createPasswordPort;
    private final DeletePasswordPort deletePasswordPort;
    private final PasswordMapper passwordMapper;
    private final PasswordGeneratorService passwordGeneratorService;
    private final UserPersistencePort userPersistencePort;


    @PostMapping("/create")
    public ResponseEntity<PasswordResponse> createPassword(@RequestBody PasswordRequest request) {

        String passwordGenerated = passwordGeneratorService.generate();
        String name = request.name();

        UUID userId = request.userId();

        User userFromDb = userPersistencePort.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        Password newPassword = new Password(passwordGenerated, name, userFromDb);

        var createdPassword = createPasswordPort.createPassword(newPassword);

        var response = passwordMapper.toResponse(createdPassword);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePassword(@PathVariable UUID id) {
        deletePasswordPort.deletePassword(id);
        return ResponseEntity.noContent().build();
    }
}
