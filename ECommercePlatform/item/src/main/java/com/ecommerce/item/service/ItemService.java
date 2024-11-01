package com.ecommerce.item.service;

import com.ecommerce.item.dao.CustomizedItemDao;
import com.ecommerce.item.dao.ItemDao;
import com.ecommerce.item.entity.Item;
import com.ecommerce.item.payload.ItemDto;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ItemService {

    ItemDto createItem(ItemDto itemDto);

    ItemDto updateItem(String itemName,ItemDto itemDto);

    void deleteItemByItemName(String itemName);

//    void deleteItemById(ObjectId id);

    List<ItemDto> findItemByItemName(String itemName);

    List<ItemDto> findItemByInventory();

    List<ItemDto> findByItemNameAndInventory(String itemName);

    // Find items with purchase limit below a certain number
    List<ItemDto> findByPurchaseLimitLessThan(int limit);


    List<ItemDto> findItemsWithInventoryGreaterThanOrEqualToPurchaseLimit();

}
