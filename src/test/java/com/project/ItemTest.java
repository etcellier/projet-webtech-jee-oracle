package com.project;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.project.dto.CategoryDTO;
import com.project.dto.ItemDTO;
import com.project.dto.ProductDTO;
import com.project.entity.Category;
import com.project.entity.Item;
import com.project.entity.Product;
import com.project.service.item.ItemMapper;
import com.project.service.product.ProductMapper;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {

    private ItemMapper itemMapper;
    private ProductMapper productMapper;

    @Before
    public void setUp() {
        // Créer un mock pour ProductMapper
        productMapper = mock(ProductMapper.class);

        // Initialiser ItemMapper avec le mock de ProductMapper
        itemMapper = new ItemMapper(productMapper);
    }

    private Product createProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Product");
        product.setDescription("Description");
        product.setPricePt(25.0);
        product.setCategory(new Category());
        return product;
    }

    private ProductDTO createProductDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Product");
        productDTO.setDescription("Description");
        productDTO.setPricePt(25.0);
        productDTO.setCategory(new CategoryDTO());
        return productDTO;
    }

    @Test
    public void testMap() {
        // Créer un objet Item fictif avec un produit associé
        Item item = new Item();
        item.setId(1L);
        item.setProduct(createProduct());
        item.setQuantity(10);
        item.setUnitPrice(25.0);

        // Configurer le mock de ProductMapper
        when(productMapper.map(item.getProduct())).thenReturn(createProductDTO());

        // Appeler la méthode map de l'ItemMapper
        ItemDTO itemDTO = itemMapper.map(item);

        // Vérifier que le mapping est correct
        assertEquals(item.getId(), itemDTO.getId());
        assertEquals(item.getProduct().getId(), itemDTO.getProduct().getId());  // Mock de ProductMapper
        assertEquals(item.getQuantity(), itemDTO.getQuantity());
        assertEquals(item.getUnitPrice(), itemDTO.getUnitPrice(), 0.01);  // Utiliser delta pour la comparaison de doubles
    }

    @Test
    public void testUpdate() {
        // Créer un objet Item fictif avec un produit associé
        Item item = new Item();
        item.setId(1L);
        item.setProduct(new Product());
        item.setQuantity(10);
        item.setUnitPrice(25.0);

        // Créer un objet ItemDTO fictif
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProduct(createProductDTO());
        itemDTO.setQuantity(15);
        itemDTO.setUnitPrice(30.0);

        // Configurer le mock de ProductMapper
        when(productMapper.update(itemDTO.getProduct(), item.getProduct())).thenReturn(createProduct());

        // Appeler la méthode update de l'ItemMapper
        Item updatedItem = itemMapper.update(itemDTO, item);

        // Vérifier que la mise à jour est correcte
        assertEquals(item.getId(), updatedItem.getId());
        assertEquals(item.getProduct().getId(), updatedItem.getProduct().getId()); // Mock de ProductMapper
        assertEquals(itemDTO.getQuantity(), updatedItem.getQuantity());
        assertEquals(itemDTO.getUnitPrice(), updatedItem.getUnitPrice(), 0.01); // Utiliser delta pour la comparaison de doubles
    }
}

