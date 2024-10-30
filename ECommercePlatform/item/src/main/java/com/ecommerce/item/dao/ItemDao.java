package com.ecommerce.item.dao;

import com.ecommerce.item.entity.Item;

public interface ItemDao {
    Item getItemById(int id);
    Item createItem(Item item);
}
