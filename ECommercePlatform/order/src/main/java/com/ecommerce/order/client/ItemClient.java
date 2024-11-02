package com.ecommerce.order.client;

import com.ecommerce.item.payload.ItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "item", url = "http://localhost:8080/items")
public interface ItemClient {
    @RequestMapping("/name/{itemName}")
    ResponseEntity<List<ItemDto>> findItemsByItemName(@PathVariable String itemName);
}
