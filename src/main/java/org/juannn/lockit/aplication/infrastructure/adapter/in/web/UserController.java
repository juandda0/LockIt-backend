package org.juannn.lockit.aplication.infrastructure.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.juannn.lockit.aplication.core.domain.port.in.user.CreateUserPort;
import org.juannn.lockit.aplication.core.domain.port.in.user.DeleteUserPort;
import org.juannn.lockit.aplication.core.domain.port.in.user.GetUserPort;
import org.juannn.lockit.aplication.core.domain.port.in.user.UpdateUserPort;
import org.juannn.lockit.aplication.shared.dto.user.UserRequest;
import org.juannn.lockit.aplication.shared.dto.user.UserResponse;
import org.juannn.lockit.aplication.shared.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserPort createUserPort;
    private final DeleteUserPort deleteUserPort;
    private final UserMapper userMapper;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        var user = userMapper.toDomain(request);
        var createdUser = createUserPort.create(user);
        var response = userMapper.toResponse(createdUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        deleteUserPort.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}