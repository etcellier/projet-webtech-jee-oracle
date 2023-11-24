package com.project.controllers;

import com.project.dto.ItemDTO;
import com.project.service.item.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItemController {

    protected final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Méthode list() qui liste les items
    @GetMapping("/items")
    public List<Optional<ItemDTO>> list() {
        return itemService.list();
    }

    // Méthode get() qui récupère un item en fonction de son id
    @GetMapping("/item/{id}")
    public Optional<ItemDTO> get(@PathVariable String id) {
        return itemService.get(Long.parseLong(id));
    }

    // Méthode create() qui crée un item grâce au body de la requête
    @PostMapping("/item")
    public void create(@RequestBody ItemDTO itemDTO) {
        itemService.create(itemDTO);
    }

    // Méthode update() qui met à jour un item grâce au body de la requête
    @PutMapping("/item")
    public void update(@RequestBody ItemDTO itemDTO) {
        itemService.update(itemDTO);
    }

    // Méthode delete() qui supprime un item en fonction de son id
    @DeleteMapping("/item/{id}")
    public void delete(@PathVariable String id) {
        itemService.delete(Long.parseLong(id));
    }
}
