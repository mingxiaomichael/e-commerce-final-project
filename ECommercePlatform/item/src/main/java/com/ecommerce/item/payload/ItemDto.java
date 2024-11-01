package com.ecommerce.item.payload;

import org.bson.types.ObjectId;

public class ItemDto {
    //private ObjectId id;

    private String itemName;

    private double price;

    private String category;

    private int purchaseLimit;

    private String inventory;

    public ItemDto() {
    }

    public ItemDto(String itemName, double price, String category, int purchaseLimit, String inventory) {
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.purchaseLimit = purchaseLimit;
        this.inventory = inventory;
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
        return "ItemDto{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", purchaseLimit=" + purchaseLimit +
                ", inventory='" + inventory + '\'' +
                '}';
    }
}
