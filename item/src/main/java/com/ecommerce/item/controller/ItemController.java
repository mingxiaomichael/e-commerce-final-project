package com.ecommerce.item.controller;

import com.ecommerce.item.payload.ItemDto;
import com.ecommerce.item.payload.ItemResponse;
import com.ecommerce.item.service.ItemService;
import com.ecommerce.item.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        ItemDto response = itemService.createItem(itemDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ItemResponse findAllItems(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ){
        return itemService.findAllItems(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/itemID/{itemID}")
    public  ResponseEntity<ItemDto> findByItemID(@PathVariable Long itemID){
        ItemDto response = itemService.findByItemID(itemID);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/name/{itemName}")
    public ResponseEntity<List<ItemDto>> findItemsByItemName(@PathVariable String itemName) {
        List<ItemDto> response = itemService.findItemByItemName(itemName);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/inventory")
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

    @GetMapping("/inventory/purchaseLimit")
    public ResponseEntity<List<ItemDto>> findItemsWithInventoryGreaterThanOrEqualToPurchaseLimit(){
        List<ItemDto> response = itemService.findItemsWithInventoryGreaterThanOrEqualToPurchaseLimit();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long itemId,@RequestBody ItemDto itemDto){
        ItemDto updateItem = itemService.updateItem(itemId,itemDto);
        return new ResponseEntity<>(updateItem,HttpStatus.OK);
    }

    @DeleteMapping("/{itemName}")
    public ResponseEntity<String> deleteItem(@PathVariable String itemName) {
        itemService.deleteItemByItemName(itemName);
        return new ResponseEntity<>("Item deleted Successfully",HttpStatus.OK);
    }
}
