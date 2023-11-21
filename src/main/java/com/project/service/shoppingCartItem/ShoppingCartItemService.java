package com.project.service.shoppingCartItem;

import com.project.dto.ShoppingCartItemDTO;
import com.project.entity.ShoppingCartItem;
import com.project.repository.ShoppingCartItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCartItemService {

    protected final ShoppingCartItemMapper shoppingCartItemMapper;
    protected final ShoppingCartItemRepository shoppingCartItemRepository;

    public ShoppingCartItemService(ShoppingCartItemMapper shoppingCartItemMapper, ShoppingCartItemRepository shoppingCartItemRepository) {
        this.shoppingCartItemMapper = shoppingCartItemMapper;
        this.shoppingCartItemRepository = shoppingCartItemRepository;
    }

    public List<Optional<ShoppingCartItemDTO>> list() {
        List<Optional<ShoppingCartItemDTO>> shoppingCartItemDTOList = new ArrayList<>();
        List<ShoppingCartItem> shoppingCartItemList = shoppingCartItemRepository.findAll();
        for (ShoppingCartItem shoppingCartItem : shoppingCartItemList) {
            shoppingCartItemDTOList.add(Optional.ofNullable(shoppingCartItemMapper.map(shoppingCartItem)));
        }
        return shoppingCartItemDTOList;
    }

    public Optional<ShoppingCartItemDTO> get(Long id) {
        Optional<ShoppingCartItem> shoppingCartItem = shoppingCartItemRepository.findById(id);
        return shoppingCartItem.map(shoppingCartItemMapper::map);
    }
}