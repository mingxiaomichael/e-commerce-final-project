package com.ecommerce.item.payload;

import org.bson.types.ObjectId;

public class ItemDto {
    //private ObjectId id;

    private int itemID;
    private String itemName;

    private double price;

    private String category;

    private int purchaseLimit;

    private int inventory;

    public ItemDto() {
    }

    public ItemDto(int itemID, String itemName, double price, String category, int purchaseLimit, int inventory) {
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
        return "ItemDto{" +
                "itemID=" + itemID +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", purchaseLimit=" + purchaseLimit +
                ", inventory=" + inventory +
                '}';
    }
}
