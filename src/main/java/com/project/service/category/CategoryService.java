package com.project.service.category;

import com.project.dto.CategoryDTO;
import com.project.entity.Category;
import com.project.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryService {

    protected final CategoryMapper categoryMapper;
    protected final CategoryRepository categoryRepository;

    public CategoryService(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    public List<Optional<CategoryDTO>> list() {
        List<Optional<CategoryDTO>> categoryDTOList = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findAll();
        for (Category category : categoryList) {
            categoryDTOList.add(Optional.ofNullable(categoryMapper.map(category)));
        }
        return categoryDTOList;
    }

    public Optional<CategoryDTO> get(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(categoryMapper::map);
    }
}
