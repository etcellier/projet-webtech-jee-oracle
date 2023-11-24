package com.project.controllers;

import com.project.dto.ProductDTO;
import com.project.service.product.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    protected final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Méthode list() qui liste les produits
    @GetMapping("/products")
    public List<Optional<ProductDTO>> list() {
        return productService.list();
    }

    // Méthode get() qui récupère un produit en fonction de son id
    @GetMapping("/product/{id}")
    public Optional<ProductDTO> get(@PathVariable String id) {
        return productService.get(Long.parseLong(id));
    }

    // Méthode create() qui crée un produit grâce au body de la requête
    @PostMapping("/product")
    public void create(@RequestBody ProductDTO productDTO) {
        productService.create(productDTO);
    }

    // Méthode update() qui met à jour un produit grâce au body de la requête
    @PutMapping("/product")
    public void update(@RequestBody ProductDTO productDTO) {
        productService.update(productDTO);
    }

    // Méthode delete() qui supprime un produit en fonction de son id
    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable String id) {
        productService.delete(Long.parseLong(id));
    }
}
