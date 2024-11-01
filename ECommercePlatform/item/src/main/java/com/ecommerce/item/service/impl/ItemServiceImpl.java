package com.ecommerce.item.service.impl;

import com.ecommerce.item.dao.ItemDao;
import com.ecommerce.item.entity.Item;
import com.ecommerce.item.payload.ItemDto;
import com.ecommerce.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemDao itemDao;
    private MongoTemplate mongoTemplate;

    @Autowired
    public ItemServiceImpl(ItemDao itemDao, MongoTemplate mongoTemplate) {
        this.itemDao = itemDao;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public ItemDto createItem(ItemDto itemDto) {
        Item item = mapToEntity(itemDto);
        Item savedItem = itemDao.save(item);
        return mapToDto(savedItem);
    }

    @Override
    public ItemDto updateItem(String itemName,ItemDto itemDtoRequest){
        Item item = itemDao.findByItemName(itemName).get(0);
        item.setPrice(itemDtoRequest.getPrice());
        item.setCategory(itemDtoRequest.getCategory());
        item.setPurchaseLimit(itemDtoRequest.getPurchaseLimit());
        item.setInventory(itemDtoRequest.getInventory());
        Item updateItem = itemDao.save(item);

        return mapToDto(updateItem);
    }

    @Override
    public void deleteItemByItemName(String itemName){
        Item item = itemDao.findByItemName(itemName).get(0);
        itemDao.delete(item);
    }

    @Override
    public List<ItemDto> findItemByItemName(String itemName) {
        List<Item> items = itemDao.findByItemName(itemName);
        return items.stream().map(item -> mapToDto(item)).collect(Collectors.toList());
    }

    @Override
    public List<ItemDto> findItemByInventory() {
        Query query = new Query();
        query.addCriteria(Criteria.where("inventory").gt(0));
        List<Item> items = mongoTemplate.find(query, Item.class);
        return items.stream().map(item -> mapToDto(item)).collect(Collectors.toList());
    }


    @Override
    public List<ItemDto> findByItemNameAndInventory(String itemName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("itemName").is(itemName).and("inventory").gt(0));
        List<Item> items = mongoTemplate.find(query, Item.class);
        return items.stream().map(item -> mapToDto(item)).collect(Collectors.toList());
    }

    //add dto
    @Override
    public List<ItemDto> findByPurchaseLimitLessThan(int limit) {
        Query query = new Query();
        query.addCriteria(Criteria.where("purchaseLimit").lt(limit));
        List<Item> items = mongoTemplate.find(query, Item.class);
        return items.stream().map(item -> mapToDto(item)).collect(Collectors.toList());
    }

    @Override
    public List<ItemDto> findItemsWithInventoryGreaterThanOrEqualToPurchaseLimit(){
        List<Item> items = itemDao.findItemsWithInventoryGreaterThanOrEqualToPurchaseLimit();
        return items.stream().map(item -> mapToDto(item)).collect(Collectors.toList());

    }

    private ItemDto mapToDto(Item item) {
        ItemDto itemDto = new ItemDto();
        //itemDto.setId(item.getId());
        itemDto.setItemName(item.getItemName());
        itemDto.setPrice(item.getPrice());
        itemDto.setCategory(item.getCategory());
        itemDto.setPurchaseLimit(item.getPurchaseLimit());
        itemDto.setInventory(item.getInventory());
        return itemDto;
    }

    private Item mapToEntity(ItemDto itemDto){
        Item item = new Item();
        //item.setId(itemDto.getId());
        item.setItemName(itemDto.getItemName());
        item.setPrice(itemDto.getPrice());
        item.setCategory(itemDto.getCategory());
        item.setPurchaseLimit(itemDto.getPurchaseLimit());
        item.setInventory(itemDto.getInventory());
        return item;
    }
}
