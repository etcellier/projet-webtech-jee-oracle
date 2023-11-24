package com.project.service.category;

import com.project.dto.CategoryDTO;
import com.project.entity.Category;
import com.project.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    protected final CategoryMapper categoryMapper;
    protected final CategoryRepository categoryRepository;

    public CategoryService(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    // Liste toutes les catégories enregistrées dans la base de données
    public List<Optional<CategoryDTO>> list() {
        List<Optional<CategoryDTO>> categoryDTOList = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findAll();
        for (Category category : categoryList) {
            categoryDTOList.add(Optional.ofNullable(categoryMapper.map(category)));
        }
        return categoryDTOList;
    }

    // Récupère une catégorie enregistrée dans la base de données
    public Optional<CategoryDTO> get(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(categoryMapper::map);
    }

    // Crée une catégorie dans la base de données
    public void create(CategoryDTO categoryDTO) {
        Category category = categoryRepository.save(categoryMapper.update(categoryDTO, new Category()));
        categoryRepository.save(category);
    }

    // Met à jour une catégorie dans la base de données
    public void update(CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(categoryDTO.getId()).get();
        category = categoryMapper.update(categoryDTO, category);
        categoryRepository.save(category);
    }

    // Supprime une catégorie de la base de données
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
