package com.ecommerce.order.payload;

import com.ecommerce.item.entity.Item;
import com.ecommerce.item.payload.ItemDto;

public class OrderDto {
    private int id;
    private String name;
    private String itemName;
    private ItemDto item;

    public OrderDto() {
    }

    public OrderDto(int id, String name, String itemName) {
        this.id = id;
        this.name = name;
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemDto getItem() {
        return item;
    }

    public void setItem(ItemDto item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemName='" + itemName + '\'' +
                ", item=" + item +
                '}';
    }
}
