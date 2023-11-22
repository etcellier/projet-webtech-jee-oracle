package com.project.controllers;

import com.project.dto.ShoppingCartItemDTO;
import com.project.service.shoppingCartItem.ShoppingCartItemService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/shoppingCartItem")
    public void create(@RequestBody ShoppingCartItemDTO shoppingCartItemDTO) {
        shoppingCartItemService.create(shoppingCartItemDTO);
    }

    @PutMapping("/shoppingCartItem")
    public void update(@RequestBody ShoppingCartItemDTO shoppingCartItemDTO) {
        shoppingCartItemService.update(shoppingCartItemDTO);
    }

    @DeleteMapping("/shoppingCartItem/{id}")
    public void delete(@PathVariable String id) {
        shoppingCartItemService.delete(Long.parseLong(id));
    }
}
