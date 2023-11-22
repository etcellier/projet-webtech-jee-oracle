package com.project.service.quote;

import com.project.dto.QuoteDTO;
import com.project.entity.Quote;
import com.project.service.shoppingCart.ShoppingCartMapper;
import com.project.service.user.UserMapper;

public class QuoteMapper {

    protected final ShoppingCartMapper shoppingCartMapper;
    protected final UserMapper userMapper;

    public QuoteMapper(ShoppingCartMapper shoppingCartMapper, UserMapper userMapper) {
        this.shoppingCartMapper = shoppingCartMapper;
        this.userMapper = userMapper;
    }

    public QuoteDTO map(Quote entity) {
        QuoteDTO dto = new QuoteDTO();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setShoppingCart(shoppingCartMapper.map(entity.getShoppingCart()));
        dto.setUser(userMapper.map(entity.getUser()));
        return dto;
    }

    public Quote update(QuoteDTO dto, Quote entity) {
        entity.setDate(dto.getDate());
        entity.setShoppingCart(shoppingCartMapper.update(dto.getShoppingCart(), entity.getShoppingCart()));
        entity.setUser(userMapper.update(dto.getUser(), entity.getUser()));
        return entity;
    }
}
