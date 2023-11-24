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

    // Méthode list() qui liste les catégories
    @GetMapping("/categories")
    public List<Optional<CategoryDTO>> list() {
        return categoryService.list();
    }

    // Méthode get() qui récupère une catégorie en fonction de son id
    @GetMapping("/category/{id}")
    public Optional<CategoryDTO> get(@PathVariable String id) {
        return categoryService.get(Long.parseLong(id));
    }

    // Méthode create() qui crée une catégorie grâce au body de la requête
    @PostMapping("/category")
    public void create(@RequestBody CategoryDTO categoryDTO) {
        categoryService.create(categoryDTO);
    }

    // Méthode update() qui met à jour une catégorie grâce au body de la requête
    @PutMapping("/category")
    public void update(@RequestBody CategoryDTO categoryDTO) {
        categoryService.update(categoryDTO);
    }

    // Méthode delete() qui supprime une catégorie en fonction de son id
    @DeleteMapping("/category/{id}")
    public void delete(@PathVariable String id) {
        categoryService.delete(Long.parseLong(id));
    }
}
