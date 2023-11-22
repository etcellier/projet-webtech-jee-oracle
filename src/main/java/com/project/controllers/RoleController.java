package com.project.controllers;

import com.project.dto.RoleDTO;
import com.project.service.role.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
