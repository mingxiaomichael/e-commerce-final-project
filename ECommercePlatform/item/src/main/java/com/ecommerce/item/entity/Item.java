package com.ecommerce.item.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "items")
public class Item {
    @Id
    private ObjectId id;
    @Field
    private String itemName;
    @Field
    private double price;

    @Field
    private String category;

    @Field
    private int purchaseLimit;

    @Field
    private String inventory;


    public Item(){

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPurchaseLimit() {
        return purchaseLimit;
    }

    public void setPurchaseLimit(int purchaseLimit) {
        this.purchaseLimit = purchaseLimit;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", purchaseLimit=" + purchaseLimit +
                ", inventory='" + inventory + '\'' +
                '}';
    }


    public Item(ObjectId id, String itemName, double price, String category, int purchaseLimit, String inventory) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.purchaseLimit = purchaseLimit;
        this.inventory = inventory;
    }
}
