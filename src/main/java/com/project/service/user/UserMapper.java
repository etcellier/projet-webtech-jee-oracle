package com.project.service.user;

import com.project.dto.UserDTO;
import com.project.entity.User;
import com.project.service.address.AddressMapper;
import com.project.service.role.RoleMapper;

public class UserMapper {

    protected final RoleMapper roleMapper;
    protected final AddressMapper addressMapper;

    public UserMapper(RoleMapper roleMapper, AddressMapper addressMapper) {
        this.roleMapper = roleMapper;
        this.addressMapper = addressMapper;
    }

    public UserDTO map(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(roleMapper.map(user.getRole()));
        userDTO.setAddress(addressMapper.map(user.getAddress()));
        return userDTO;
    }

    public User update(UserDTO userDTO, User user) {
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setRole(roleMapper.update(userDTO.getRole(), user.getRole()));
        user.setAddress(addressMapper.update(userDTO.getAddress(), user.getAddress()));
        return user;
    }
}
