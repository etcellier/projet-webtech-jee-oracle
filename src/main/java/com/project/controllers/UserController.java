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

    // Méthode list() qui liste les users
    @GetMapping("/users")
    public List<Optional<UserDTO>> list() {
        return userService.list();
    }

    // Méthode get() qui récupère un user en fonction de son id
    @GetMapping("/user/{id}")
    public Optional<UserDTO> get(@PathVariable String id) {
        return userService.get(Long.parseLong(id));
    }

    // Méthode create() qui crée un user grâce au body de la requête
    @PostMapping("/user")
    public void create(@RequestBody UserDTO userDTO) {
        userService.create(userDTO);
    }

    // Méthode update() qui met à jour un user grâce au body de la requête
    @PutMapping("/user")
    public void update(@RequestBody UserDTO userDTO) {
        userService.update(userDTO);
    }

    // Méthode delete() qui supprime un user en fonction de son id
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(Long.parseLong(id));
    }
}
