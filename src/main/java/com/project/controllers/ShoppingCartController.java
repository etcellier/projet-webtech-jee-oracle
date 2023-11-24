package com.project.controllers;

import com.project.dto.ShoppingCartDTO;
import com.project.service.shoppingCart.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ShoppingCartController {

    protected final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    // Méthode list() qui liste les shoppingCarts
    @GetMapping("/shoppingCarts")
    public List<Optional<ShoppingCartDTO>> list() {
        return shoppingCartService.list();
    }

    // Méthode get() qui récupère un shoppingCart en fonction de son id
    @GetMapping("/shoppingCart/{id}")
    public Optional<ShoppingCartDTO> get(@PathVariable String id) {
        return shoppingCartService.get(Long.parseLong(id));
    }

    // Méthode create() qui crée un shoppingCart grâce au body de la requête
    @PostMapping("/shoppingCart")
    public void create(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        shoppingCartService.create(shoppingCartDTO);
    }

    // Méthode update() qui met à jour un shoppingCart grâce au body de la requête
    @PutMapping("/shoppingCart")
    public void update(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        shoppingCartService.update(shoppingCartDTO);
    }

    // Méthode delete() qui supprime un shoppingCart en fonction de son id
    @DeleteMapping("/shoppingCart/{id}")
    public void delete(@PathVariable String id) {
        shoppingCartService.delete(Long.parseLong(id));
    }
}
