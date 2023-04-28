package com.service.itemservice.service;

import com.service.itemservice.domain.Item;
import com.service.itemservice.enums.ItemName;

import java.util.List;

public interface ItemService {

    Item addStock(ItemName itemName,int stock);

    String toOrder(ItemName itemName);

    List<Item> getItems();
}
