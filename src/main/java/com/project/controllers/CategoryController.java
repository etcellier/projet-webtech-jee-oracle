package com.project.controllers;

import com.project.dto.CategoryDTO;
import com.project.service.category.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {

    protected final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Optional<CategoryDTO>> list() {
        return categoryService.list();
    }

    @GetMapping("/category/{id}")
    public Optional<CategoryDTO> get(@PathVariable String id) {
        return categoryService.get(Long.parseLong(id));
    }
}
