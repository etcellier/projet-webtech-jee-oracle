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

    // Méthode list() qui liste les shoppingCartItems
    @GetMapping("/shoppingCartItems")
    public List<Optional<ShoppingCartItemDTO>> list() {
        return shoppingCartItemService.list();
    }

    // Méthode get() qui récupère un shoppingCartItem en fonction de son id
    @GetMapping("/shoppingCartItem/{id}")
    public Optional<ShoppingCartItemDTO> get(@PathVariable String id) {
        return shoppingCartItemService.get(Long.parseLong(id));
    }

    // Méthode create() qui crée un shoppingCartItem grâce au body de la requête
    @PostMapping("/shoppingCartItem")
    public void create(@RequestBody ShoppingCartItemDTO shoppingCartItemDTO) {
        shoppingCartItemService.create(shoppingCartItemDTO);
    }

    // Méthode update() qui met à jour un shoppingCartItem grâce au body de la requête
    @PutMapping("/shoppingCartItem")
    public void update(@RequestBody ShoppingCartItemDTO shoppingCartItemDTO) {
        shoppingCartItemService.update(shoppingCartItemDTO);
    }

    // Méthode delete() qui supprime un shoppingCartItem en fonction de son id
    @DeleteMapping("/shoppingCartItem/{id}")
    public void delete(@PathVariable String id) {
        shoppingCartItemService.delete(Long.parseLong(id));
    }
}
