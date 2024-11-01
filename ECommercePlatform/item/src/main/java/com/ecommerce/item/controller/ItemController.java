package com.ecommerce.item.controller;

import com.ecommerce.item.ItemApplication;
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

    @GetMapping()
    public ResponseEntity<List<ItemDto>> findByInventory(){
        List<ItemDto> response = itemService.findItemByInventory();
        return ResponseEntity.ok(response);
    }


    @GetMapping("/name/inventory/{itemName}")
    public ResponseEntity<List<ItemDto>> findByItemNameAndInventory(@PathVariable String itemName){
        List<ItemDto> response = itemService.findByItemNameAndInventory(itemName);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/purchaseLimit/{limit}")
    public ResponseEntity<List<ItemDto>> findByPurchaseLimitLessThan(@PathVariable int limit){
        List<ItemDto> response = itemService.findByPurchaseLimitLessThan(limit);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<ItemDto>> findItemsWithInventoryGreaterThanOrEqualToPurchaseLimit(){
        List<ItemDto> response = itemService.findItemsWithInventoryGreaterThanOrEqualToPurchaseLimit();
        return ResponseEntity.ok(response);
    }



    @PutMapping("/{itemName}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable String itemName,@RequestBody ItemDto itemDto){
        ItemDto updateItem = itemService.updateItem(itemName,itemDto);
        return new ResponseEntity<>(updateItem,HttpStatus.OK);
    }

    @DeleteMapping("/{itemName}")
    public ResponseEntity<String> deleteItem(@PathVariable String itemName) {
        itemService.deleteItemByItemName(itemName);
        return new ResponseEntity<>("Item deleted Successfully",HttpStatus.OK);
    }


}
