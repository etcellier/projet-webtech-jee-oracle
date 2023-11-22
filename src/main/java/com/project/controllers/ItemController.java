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

    @GetMapping("/items")
    public List<Optional<ItemDTO>> list() {
        return itemService.list();
    }

    @GetMapping("/item/{id}")
    public Optional<ItemDTO> get(@PathVariable String id) {
        return itemService.get(Long.parseLong(id));
    }

    @PostMapping("/item")
    public void create(@RequestBody ItemDTO itemDTO) {
        itemService.create(itemDTO);
    }

    @PutMapping("/item")
    public void update(@RequestBody ItemDTO itemDTO) {
        itemService.update(itemDTO);
    }

    @DeleteMapping("/item/{id}")
    public void delete(@PathVariable String id) {
        itemService.delete(Long.parseLong(id));
    }
}
