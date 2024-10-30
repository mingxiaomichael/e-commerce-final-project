package com.ecommerce.item.controller;

import com.ecommerce.item.dao.ItemDao;
import com.ecommerce.item.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ItemController {
    private final ItemDao itemDao;

    @Autowired
    public ItemController(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @GetMapping("/{itemId}")
    public Item getItemById(@PathVariable int itemId) {
        return itemDao.getItemById(itemId);
    }

    @PostMapping()
    public Item createItem(@RequestBody Item item) {
        return itemDao.createItem(item);
    }
}
