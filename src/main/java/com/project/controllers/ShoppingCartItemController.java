package com.project.controllers;

import com.project.dto.ShoppingCartItemDTO;
import com.project.service.shoppingCartItem.ShoppingCartItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ShoppingCartItemController {

    protected final ShoppingCartItemService shoppingCartItemService;

    public ShoppingCartItemController(ShoppingCartItemService shoppingCartItemService) {
        this.shoppingCartItemService = shoppingCartItemService;
    }

    @GetMapping("/shoppingCartItems")
    public List<Optional<ShoppingCartItemDTO>> list() {
        return shoppingCartItemService.list();
    }

    @GetMapping("/shoppingCartItem/{id}")
    public Optional<ShoppingCartItemDTO> get(@PathVariable String id) {
        return shoppingCartItemService.get(Long.parseLong(id));
    }
}
