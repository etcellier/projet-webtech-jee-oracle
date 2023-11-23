package com.project;


import com.project.dto.CategoryDTO;
import com.project.entity.Category;
import com.project.service.category.CategoryMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    private CategoryMapper categoryMapper;

    @Before
    public void setUp() {
        categoryMapper = new CategoryMapper();
    }

    @Test
    public void testMap() {
        // Créer un objet Category fictif
        Category category = new Category();
        category.setId(1L);
        category.setName("Nom");
        category.setDescription("Description");

        // Appeler la méthode map de l'CategoryMapper
        CategoryDTO categoryDTO = categoryMapper.map(category);

        // Vérifier que le mapping est correct
        assertEquals(category.getId(), categoryDTO.getId());
        assertEquals(category.getName(), categoryDTO.getName());
        assertEquals(category.getDescription(), categoryDTO.getDescription());
    }

    @Test
    public void testUpdate() {
        // Créer un objet Category fictif
        Category category = new Category();
        category.setId(1L);
        category.setName("Nom");
        category.setDescription("Description");

        // Créer un objet CategoryDTO fictif
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName("Nom2");
        categoryDTO.setDescription("Description2");

        // Appeler la méthode update de l'CategoryMapper
        Category updatedCategory = categoryMapper.update(categoryDTO, category);
        assertEquals(category.getId(), updatedCategory.getId());
        assertEquals(categoryDTO.getName(), updatedCategory.getName());
        assertEquals(categoryDTO.getDescription(), updatedCategory.getDescription());
    }

}
