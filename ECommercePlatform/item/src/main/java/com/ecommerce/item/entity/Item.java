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
    private  int itemID;

    @Field
    private String itemName;

    @Field
    private double price;

    @Field
    private String category;

    @Field
    private int purchaseLimit;

    @Field
    private int inventory;

    public Item(){
    }

    public Item(ObjectId id, int itemID,String itemName, double price, String category, int purchaseLimit, int inventory) {
        this.id = id;
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.purchaseLimit = purchaseLimit;
        this.inventory = inventory;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
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
                ", itemID=" + itemID +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", purchaseLimit=" + purchaseLimit +
                ", inventory=" + inventory +
                '}';
    }
}
