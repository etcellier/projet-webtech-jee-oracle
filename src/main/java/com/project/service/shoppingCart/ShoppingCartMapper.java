package com.project.service.shoppingCart;

import com.project.dto.ShoppingCartDTO;
import com.project.entity.ShoppingCart;
import com.project.service.user.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartMapper {

    protected final UserMapper userMapper;

    public ShoppingCartMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ShoppingCartDTO map(ShoppingCart entity) {
        ShoppingCartDTO dto = new ShoppingCartDTO();
        dto.setId(entity.getId());
        dto.setTotal(entity.getTotal());
        dto.setUser(userMapper.map(entity.getUser()));
        return dto;
    }

    public ShoppingCart update(ShoppingCartDTO dto, ShoppingCart entity) {
        entity.setTotal(dto.getTotal());
        entity.setUser(userMapper.update(dto.getUser(), entity.getUser()));
        return entity;
    }
}
