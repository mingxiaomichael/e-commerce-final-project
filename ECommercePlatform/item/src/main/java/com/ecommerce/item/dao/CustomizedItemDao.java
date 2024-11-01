package com.ecommerce.item.dao;

import com.ecommerce.item.entity.Item;

import java.util.List;

public interface CustomizedItemDao {
    List<Item> findItemByInventory();

    List<Item> findByItemNameAndInventory(String ItemName, String inventory);

    // Find items with purchase limit below a certain number
    List<Item> findByPurchaseLimitLessThan(int limit);


}
