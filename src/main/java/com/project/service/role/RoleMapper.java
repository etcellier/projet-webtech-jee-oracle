package com.project.service.role;

import com.project.dto.RoleDTO;
import com.project.entity.Role;

public class RoleMapper {

    public RoleDTO map(Role entity) {
        RoleDTO dto = new RoleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public Role update(RoleDTO dto, Role entity) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
