package com.service.itemservice.service;

import com.service.itemservice.domain.Item;
import com.service.itemservice.enums.ItemName;
import com.service.itemservice.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service

public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item addStock(ItemName itemName, int stock) {
        Item item = itemRepository.findByItemName(itemName);

        if (itemName==null) throw new NotFoundException(String.format("%s %s","Item was not found with name:",itemName));

        if (item.getStock()<=0)item.setStock(item.getStock()+stock);
        return itemRepository.save(item);
    }

    @Override
    public String toOrder(ItemName itemName) {

        Item item = itemRepository.findByItemName(itemName);

        if (itemName==null) throw new NotFoundException(String.format("%s %s","Item was not found with name:",itemName));

        item.setStock(item.getStock()-1);
        itemRepository.save(item);
        return String.format("%s %s",itemName," order created successfully");
    }

    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

}
