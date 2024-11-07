package com.ecommerce.order.client;

import com.ecommerce.item.payload.ItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "item", url = "http://localhost:8080/items",configuration = FeignClientConfig.class)
public interface ItemClient {
    @RequestMapping("/name/{itemName}")
    ResponseEntity<List<ItemDto>> findItemsByItemName(@PathVariable String itemName);

    @GetMapping("/itemID/{itemID}")
    ResponseEntity<ItemDto> findByItemID(@PathVariable Long itemID);

    @PutMapping("/{itemId}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long itemId,@RequestBody ItemDto itemDto);
}

