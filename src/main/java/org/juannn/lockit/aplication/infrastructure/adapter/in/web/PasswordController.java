package org.juannn.lockit.aplication.infrastructure.adapter.in.web;


import lombok.RequiredArgsConstructor;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/passwords")
@RequiredArgsConstructor
public class PasswordController {

    private final CreatePasswordPort createPasswordPort;
    private final GetAllPasswordPort getAllPasswordPort;
    private final DeletePasswordPort deletePasswordPort;
    private final PasswordMapper passwordMapper;

    @PostMapping("/create")
    public ResponseEntity<PasswordResponse> createPassword(@RequestBody PasswordRequest request) {
        var password = passwordMapper.toDomain(request);
        var createdPassword = createPasswordPort.create(password);
        var response = passwordMapper.toResponse(createdPassword);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePassword(@PathVariable Long id) {
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
