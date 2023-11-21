package com.project.service.product;

import com.project.dto.ProductDTO;
import com.project.entity.Product;
import com.project.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {

    protected final ProductMapper productMapper;
    protected final ProductRepository productRepository;

    public ProductService(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    public List<Optional<ProductDTO>> list() {
        List<Optional<ProductDTO>> productDTOList = new ArrayList<>();
        List<Product> productList = productRepository.findAll();
        for (Product product : productList) {
            productDTOList.add(Optional.ofNullable(productMapper.map(product)));
        }
        return productDTOList;
    }

    public Optional<ProductDTO> get(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(productMapper::map);
    }
}
