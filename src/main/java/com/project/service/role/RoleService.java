package com.project.service.role;

import com.project.dto.RoleDTO;
import com.project.entity.Role;
import com.project.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleService {

    protected final RoleMapper roleMapper;
    protected final RoleRepository roleRepository;

    public RoleService(RoleMapper roleMapper, RoleRepository roleRepository) {
        this.roleMapper = roleMapper;
        this.roleRepository = roleRepository;
    }

    public List<Optional<RoleDTO>> list() {
        List<Optional<RoleDTO>> roleDTOList = new ArrayList<>();
        List<Role> roleList = roleRepository.findAll();
        for (Role role : roleList) {
            roleDTOList.add(Optional.ofNullable(roleMapper.map(role)));
        }
        return roleDTOList;
    }

    public Optional<RoleDTO> get(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.map(roleMapper::map);
    }

    public void create(RoleDTO roleDTO) {
        Role role = roleMapper.update(roleDTO, new Role());
        roleRepository.save(role);
    }

    public void update(RoleDTO roleDTO) {
        Role role = roleRepository.findById(roleDTO.getId()).get();
        role = roleMapper.update(roleDTO, role);
        roleRepository.save(role);
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
