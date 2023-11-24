package com.project.service.item;

import com.project.dto.ItemDTO;
import com.project.entity.Item;
import com.project.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    protected final ItemMapper itemMapper;
    protected final ItemRepository itemRepository;

    public ItemService(ItemMapper itemMapper, ItemRepository itemRepository) {
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
    }

    // Liste les items enregistrés dans la base de données
    public List<Optional<ItemDTO>> list() {
        List<Optional<ItemDTO>> itemDTOList = new ArrayList<>();
        List<Item> itemList = itemRepository.findAll();
        for (Item item : itemList) {
            itemDTOList.add(Optional.ofNullable(itemMapper.map(item)));
        }
        return itemDTOList;
    }

    // Récupère un item enregistré dans la base de données
    public Optional<ItemDTO> get(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.map(itemMapper::map);
    }

    // Crée un item dans la base de données
    public void create(ItemDTO itemDTO) {
        Item item = itemRepository.save(itemMapper.update(itemDTO, new Item()));
        itemRepository.save(item);
    }

    // Met à jour un item dans la base de données
    public void update(ItemDTO itemDTO) {
        Item item = itemRepository.findById(itemDTO.getId()).get();
        item = itemMapper.update(itemDTO, item);
        itemRepository.save(item);
    }

    // Supprime un item de la base de données
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
