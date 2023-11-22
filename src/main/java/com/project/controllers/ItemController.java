package com.project.controllers;

import com.project.dto.ItemDTO;
import com.project.service.item.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
