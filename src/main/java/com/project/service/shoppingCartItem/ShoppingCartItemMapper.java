package com.project.service.shoppingCartItem;

import com.project.dto.ShoppingCartItemDTO;
import com.project.entity.ShoppingCartItem;
import com.project.service.item.ItemMapper;
import com.project.service.shoppingCart.ShoppingCartMapper;

public class ShoppingCartItemMapper {

    protected final ShoppingCartMapper shoppingCartMapper;
    protected final ItemMapper itemMapper;

    public ShoppingCartItemMapper(ShoppingCartMapper shoppingCartMapper, ItemMapper itemMapper) {
        this.shoppingCartMapper = shoppingCartMapper;
        this.itemMapper = itemMapper;
    }

    public ShoppingCartItemDTO map(ShoppingCartItem entity) {
        ShoppingCartItemDTO dto = new ShoppingCartItemDTO();
        dto.setId(entity.getId());
        dto.setShoppingCart(shoppingCartMapper.map(entity.getShoppingCart()));
        dto.setItem(itemMapper.map(entity.getItem()));
        return dto;
    }

    public ShoppingCartItem update(ShoppingCartItemDTO dto, ShoppingCartItem entity) {
        entity.setShoppingCart(shoppingCartMapper.update(dto.getShoppingCart(), entity.getShoppingCart()));
        entity.setItem(itemMapper.update(dto.getItem(), entity.getItem()));
        return entity;
    }
}
