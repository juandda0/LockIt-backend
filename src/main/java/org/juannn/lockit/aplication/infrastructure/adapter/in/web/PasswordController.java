package org.juannn.lockit.aplication.infrastructure.adapter.in.web;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.juannn.lockit.aplication.core.domain.model.Password;
import org.juannn.lockit.aplication.core.domain.port.in.password.CreatePasswordPort;
import org.juannn.lockit.aplication.core.domain.port.in.password.DeletePasswordPort;
import org.juannn.lockit.aplication.core.domain.port.in.password.GetAllPasswordPort;
import org.juannn.lockit.aplication.shared.dto.password.PasswordRequest;
import org.juannn.lockit.aplication.shared.dto.password.PasswordResponse;
import org.juannn.lockit.aplication.shared.mapper.PasswordMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/passwords")
@RequiredArgsConstructor
@Slf4j
public class PasswordController {

    private final CreatePasswordPort createPasswordPort;
    private final GetAllPasswordPort getAllPasswordPort;
    private final DeletePasswordPort deletePasswordPort;
    private final PasswordMapper passwordMapper;

    @PostMapping("/create")
    public ResponseEntity<PasswordResponse> createPassword(@RequestBody PasswordRequest request) {
        log.debug("Recibida petición POST /passwords/create con Request: {}", request);
        // Punto de debug 1: Estado del DTO de entrada.
        log.debug("PasswordRequest.generatedPassword: {}", request != null ? request.getGeneratedPassword() : "null request object");

        var password = passwordMapper.toDomain(request);
        // Punto de debug 2: Estado del modelo de dominio después del mapeo del DTO de entrada.
        log.debug("Mapeado PasswordRequest a Dominio Password: {}", password);
        log.debug("Dominio Password.id: {}", password != null ? password.getId() : "null");
        log.debug("Dominio Password.generatedPassword: {}", password != null ? password.getGeneratedPassword() : "null");


        var createdPassword = createPasswordPort.create(password);
        // Punto de debug 3: Estado del modelo de dominio después de la creación/persistencia.
        log.debug("Password creado y persistido: {}", createdPassword);

        var response = passwordMapper.toResponse(createdPassword);
        log.debug("Mapeado a PasswordResponse: {}", response);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePassword(@PathVariable UUID id) {
        deletePasswordPort.deletePassword(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<List<PasswordResponse>> getAllPasswords() {
        List<Password> passwords = getAllPasswordPort.getAllPasswords();
        List<PasswordResponse> passwordResponses = passwords.stream()
                .map(passwordMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(passwordResponses);
    }

}
