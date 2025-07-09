package org.juannn.lockit.aplication.infrastructure.adapter.in.web;

import lombok.AllArgsConstructor;
import org.juannn.lockit.aplication.core.domain.model.User;
import org.juannn.lockit.aplication.core.domain.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
