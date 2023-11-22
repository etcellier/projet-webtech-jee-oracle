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

    @GetMapping("/products")
    public List<Optional<ProductDTO>> list() {
        return productService.list();
    }

    @GetMapping("/product/{id}")
    public Optional<ProductDTO> get(@PathVariable String id) {
        return productService.get(Long.parseLong(id));
    }

    @PostMapping("/product")
    public void create(@RequestBody ProductDTO productDTO) {
        productService.create(productDTO);
    }

    @PutMapping("/product")
    public void update(@RequestBody ProductDTO productDTO) {
        productService.update(productDTO);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable String id) {
        productService.delete(Long.parseLong(id));
    }
}
