package com.ecommerce.item.controller;

import com.ecommerce.item.entity.Item;
import com.ecommerce.item.payload.ItemDto;
import com.ecommerce.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        ItemDto response = itemService.createItem(itemDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/name/{itemName}")
    public ResponseEntity<List<ItemDto>> findItemsByItemName(@PathVariable String itemName) {
        List<ItemDto> response = itemService.findItemByItemName(itemName);
        return ResponseEntity.ok(response);
    }
}
