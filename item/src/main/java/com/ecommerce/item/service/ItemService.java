package com.ecommerce.item.service;

import com.ecommerce.item.payload.ItemDto;
import com.ecommerce.item.payload.ItemResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    ItemDto createItem(ItemDto itemDto);

    ItemResponse findAllItems(int pageNo, int pageSize, String sortBy, String sortDir);

    ItemDto findByItemID(Long itemID);

    ItemDto updateItem(Long itemId,ItemDto itemDto);

    void deleteItemByItemName(String itemName);

//    void deleteItemById(ObjectId id);

    List<ItemDto> findItemByItemName(String itemName);

    List<ItemDto> findItemByInventory();

    List<ItemDto> findByItemNameAndInventory(String itemName);

    // Find items with purchase limit below a certain number
    List<ItemDto> findByPurchaseLimitLessThan(int limit);


    List<ItemDto> findItemsWithInventoryGreaterThanOrEqualToPurchaseLimit();

}
