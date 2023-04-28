package com.service.itemservice.domain;

import com.service.itemservice.enums.ItemName;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;

    @Enumerated(EnumType.STRING)
    ItemName itemName;

    int stock;


    public Item() {
    }

    public Item(ItemName itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    public Item(String id, ItemName itemName, int stock) {
        this.id = id;
        this.itemName = itemName;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ItemName getItemName() {
        return itemName;
    }

    public void setItemName(ItemName itemName) {
        this.itemName = itemName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", itemName=" + itemName +
                ", stock=" + stock +
                '}'+"\n";
    }
}
