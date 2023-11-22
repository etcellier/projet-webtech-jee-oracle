package com.project.service.shoppingCart;

import com.project.dto.ShoppingCartDTO;
import com.project.entity.ShoppingCart;
import com.project.repository.ShoppingCartRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCartService {

    protected final ShoppingCartMapper shoppingCartMapper;
    protected final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(ShoppingCartMapper shoppingCartMapper, ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartMapper = shoppingCartMapper;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<Optional<ShoppingCartDTO>> list() {
        List<Optional<ShoppingCartDTO>> shoppingCartDTOList = new ArrayList<>();
        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAll();
        for (ShoppingCart shoppingCart : shoppingCartList) {
            shoppingCartDTOList.add(Optional.ofNullable(shoppingCartMapper.map(shoppingCart)));
        }
        return shoppingCartDTOList;
    }

    public Optional<ShoppingCartDTO> get(Long id) {
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(id);
        return shoppingCart.map(shoppingCartMapper::map);
    }

    public void create(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = shoppingCartMapper.update(shoppingCartDTO, new ShoppingCart());
        shoppingCartRepository.save(shoppingCart);
    }

    public void update(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartDTO.getId()).get();
        shoppingCart = shoppingCartMapper.update(shoppingCartDTO, shoppingCart);
        shoppingCartRepository.save(shoppingCart);
    }

    public void delete(Long id) {
        shoppingCartRepository.deleteById(id);
    }
}
