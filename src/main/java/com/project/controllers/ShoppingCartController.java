package com.project.controllers;

import com.project.dto.ShoppingCartDTO;
import com.project.service.shoppingCart.ShoppingCartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ShoppingCartController {

    protected final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/shoppingCarts")
    public List<Optional<ShoppingCartDTO>> list() {
        return shoppingCartService.list();
    }

    @GetMapping("/shoppingCart/{id}")
    public Optional<ShoppingCartDTO> get(@PathVariable String id) {
        return shoppingCartService.get(Long.parseLong(id));
    }
}
