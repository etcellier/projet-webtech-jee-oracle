package com.project.service.category;

import com.project.dto.CategoryDTO;
import com.project.entity.Category;

public class CategoryMapper {

    public CategoryDTO map(Category entity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public Category update(CategoryDTO dto, Category entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
