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

    @GetMapping("/roles")
    public List<Optional<RoleDTO>> list() {
        return roleService.list();
    }

    @GetMapping("/role/{id}")
    public Optional<RoleDTO> get(@PathVariable String id) {
        return roleService.get(Long.parseLong(id));
    }

    @PostMapping("/role")
    public void create(@RequestBody RoleDTO roleDTO) {
        roleService.create(roleDTO);
    }

    @PutMapping("/role")
    public void update(@RequestBody RoleDTO roleDTO) {
        roleService.update(roleDTO);
    }

    @DeleteMapping("/role/{id}")
    public void delete(@PathVariable String id) {
        roleService.delete(Long.parseLong(id));
    }
}
