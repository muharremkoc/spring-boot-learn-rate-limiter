package com.service.itemservice.repository;

import com.service.itemservice.domain.Item;
import com.service.itemservice.enums.ItemName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,String> {


    Item findByItemName(ItemName itemName);

}
