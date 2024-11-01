package com.ecommerce.item.service;

import com.ecommerce.item.dao.CustomizedItemDao;
import com.ecommerce.item.dao.ItemDao;
import com.ecommerce.item.entity.Item;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ItemService {

    List<Item> findItemByInventory();

    List<Item> findByItemNameAndInventory(String itemName, String inventory);

    // Find items with purchase limit below a certain number
    List<Item> findByPurchaseLimitLessThan(int limit);

    List<Item> findByInventoryMoreThanPurchaseLimit();

}
