package com.project.service.product;

import com.project.dto.ProductDTO;
import com.project.entity.Product;
import com.project.service.category.CategoryMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    protected final CategoryMapper categoryMapper;

    public ProductMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    // Map entity to DTO
    public ProductDTO map(Product entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPricePt(entity.getPricePt());
        dto.setCategory(categoryMapper.map(entity.getCategory()));
        return dto;
    }

    // Update entity with DTO
    public Product update(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPricePt(dto.getPricePt());
        entity.setCategory(categoryMapper.update(dto.getCategory(), entity.getCategory()));
        return entity;
    }
}
