package com.project.controllers;

import com.project.dto.CategoryDTO;
import com.project.service.category.CategoryService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/category")
    public void create(@RequestBody CategoryDTO categoryDTO) {
        categoryService.create(categoryDTO);
    }

    @PutMapping("/category")
    public void update(@RequestBody CategoryDTO categoryDTO) {
        categoryService.update(categoryDTO);
    }

    @DeleteMapping("/category/{id}")
    public void delete(@PathVariable String id) {
        categoryService.delete(Long.parseLong(id));
    }
}
