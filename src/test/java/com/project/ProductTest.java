package com.project;

import com.project.dto.CategoryDTO;
import com.project.dto.ProductDTO;
import com.project.entity.Category;
import com.project.entity.Product;
import com.project.service.category.CategoryMapper;
import com.project.service.product.ProductMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductTest {

    private ProductMapper productMapper;
    private CategoryMapper categoryMapper;

    @Before
    public void setUp() {
        // Créer un mock pour CategoryMapper
        categoryMapper = mock(CategoryMapper.class);

        // Initialiser ProductMapper avec le mock de CategoryMapper
        productMapper = new ProductMapper(categoryMapper);
    }

    private Category createCategory() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Category");
        category.setDescription("Description");
        return category;
    }

    private CategoryDTO createCategoryDTO() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(1L);
        categoryDTO.setName("Category");
        categoryDTO.setDescription("Description");
        return categoryDTO;
    }

    @Test
    public void testMap() {
        // Créer un objet Product fictif avec une catégorie associée
        Product product = new Product();
        product.setId(1L);
        product.setName("Product");
        product.setDescription("Description");
        product.setPricePt(25.0);
        product.setCategory(createCategory());

        // Créer un mock pour CategoryMapper
        when(categoryMapper.map(product.getCategory())).thenReturn(createCategoryDTO());

        // Appeler la méthode map de l'ProductMapper
        ProductDTO productDTO = productMapper.map(product);

        // Vérifier que le mapping est correct
        assertEquals(product.getId(), productDTO.getId());
        assertEquals(product.getName(), productDTO.getName());
        assertEquals(product.getDescription(), productDTO.getDescription());
        assertEquals(product.getPricePt(), productDTO.getPricePt());
        assertEquals(product.getCategory().getId(), productDTO.getCategory().getId());
        assertEquals(product.getCategory().getName(), productDTO.getCategory().getName());
        assertEquals(product.getCategory().getDescription(), productDTO.getCategory().getDescription());
    }

    @Test
    public void testUpdate() {
        // Créer un objet Product fictif avec une catégorie associée
        Product product = new Product();
        product.setId(1L);
        product.setName("Product");
        product.setDescription("Description");
        product.setPricePt(25.0);
        product.setCategory(createCategory());

        // Créer un objet ProductDTO fictif
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Product2");
        productDTO.setDescription("Description2");
        productDTO.setPricePt(50.0);
        productDTO.setCategory(createCategoryDTO());

        // Créer un mock pour CategoryMapper
        when(categoryMapper.update(productDTO.getCategory(), product.getCategory())).thenReturn(createCategory());

        // Appeler la méthode update de l'ProductMapper
        Product updatedProduct = productMapper.update(productDTO, product);
        assertEquals(product.getId(), updatedProduct.getId());
        assertEquals(productDTO.getName(), updatedProduct.getName());
        assertEquals(productDTO.getDescription(), updatedProduct.getDescription());
        assertEquals(productDTO.getPricePt(), updatedProduct.getPricePt());
        assertEquals(product.getCategory().getId(), updatedProduct.getCategory().getId());
        assertEquals(product.getCategory().getName(), updatedProduct.getCategory().getName());
        assertEquals(product.getCategory().getDescription(), updatedProduct.getCategory().getDescription());
    }
}
