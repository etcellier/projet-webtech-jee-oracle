package com.project.controllers;

import com.project.dto.UserDTO;
import com.project.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    protected final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Optional<UserDTO>> list() {
        return userService.list();
    }

    @GetMapping("/user/{id}")
    public Optional<UserDTO> get(@PathVariable String id) {
        return userService.get(Long.parseLong(id));
    }

    @PostMapping("/user")
    public void create(@RequestBody UserDTO userDTO) {
        userService.create(userDTO);
    }

    @PutMapping("/user")
    public void update(@RequestBody UserDTO userDTO) {
        userService.update(userDTO);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(Long.parseLong(id));
    }
}
