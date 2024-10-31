package com.ecommerce.item.controller;

import com.ecommerce.item.entity.Item;
import com.ecommerce.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @GetMapping("/name/{name}")
    public List<Item> getItemsByName(@PathVariable String name) {
        return itemService.findItemsByName(name);
    }
}
