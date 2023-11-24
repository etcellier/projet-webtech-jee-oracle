package com.project.service.item;


import com.project.dto.ItemDTO;
import com.project.entity.Item;
import com.project.service.product.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemMapper {

    protected final ProductMapper productMapper;

    public ItemMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    // Map entity to DTO
    public ItemDTO map(Item entity) {
        ItemDTO dto = new ItemDTO();
        dto.setId(entity.getId());
        dto.setProduct(productMapper.map(entity.getProduct()));
        dto.setQuantity(entity.getQuantity());
        dto.setUnitPrice(entity.getUnitPrice());
        return dto;
    }

    // Update entity with DTO
    public Item update(ItemDTO dto, Item entity) {
        entity.setProduct(productMapper.update(dto.getProduct(), entity.getProduct()));
        entity.setQuantity(dto.getQuantity());
        entity.setUnitPrice(dto.getUnitPrice());
        return entity;
    }

}
