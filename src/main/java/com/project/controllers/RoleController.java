package com.project.controllers;

import com.project.dto.RoleDTO;
import com.project.service.role.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoleController {

    protected final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // Méthode list() qui liste les roles
    @GetMapping("/roles")
    public List<Optional<RoleDTO>> list() {
        return roleService.list();
    }

    // Méthode get() qui récupère un role en fonction de son id
    @GetMapping("/role/{id}")
    public Optional<RoleDTO> get(@PathVariable String id) {
        return roleService.get(Long.parseLong(id));
    }

    // Méthode create() qui crée un role grâce au body de la requête
    @PostMapping("/role")
    public void create(@RequestBody RoleDTO roleDTO) {
        roleService.create(roleDTO);
    }

    // Méthode update() qui met à jour un role grâce au body de la requête
    @PutMapping("/role")
    public void update(@RequestBody RoleDTO roleDTO) {
        roleService.update(roleDTO);
    }

    // Méthode delete() qui supprime un role en fonction de son id
    @DeleteMapping("/role/{id}")
    public void delete(@PathVariable String id) {
        roleService.delete(Long.parseLong(id));
    }
}
