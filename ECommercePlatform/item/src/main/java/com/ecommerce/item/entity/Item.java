package com.ecommerce.item.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "items") // Specifies the collection name in MongoDB
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private int purchaseLimit;
    private String category;
    private int inventory;

    public Item(Long id, String itemName, int purchaseLimit, String category, int inventory) {
        this.id = id;
        this.itemName = itemName;
        this.purchaseLimit = purchaseLimit;
        this.category = category;
        this.inventory = inventory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPurchaseLimit() {
        return purchaseLimit;
    }

    public void setPurchaseLimit(int purchaseLimit) {
        this.purchaseLimit = purchaseLimit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", purchaseLimit=" + purchaseLimit +
                ", category='" + category + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
