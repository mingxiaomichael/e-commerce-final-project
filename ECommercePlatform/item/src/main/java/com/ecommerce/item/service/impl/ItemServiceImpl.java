package com.ecommerce.item.service.impl;

import com.ecommerce.item.dao.ItemDao;
import com.ecommerce.item.entity.Item;
import com.ecommerce.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {


    //private ItemDao itemDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Item> findItemByInventory() {
        Query query = new Query();
        query.addCriteria(Criteria.where("inventory").gt(0));
        return mongoTemplate.find(query, Item.class);
    }


    @Override
    public List<Item> findByItemNameAndInventory(String itemName, String inventory) {
        Query query = new Query();
        query.addCriteria(Criteria.where("itemName").is(itemName)
                .and("inventory").gt(0)); // if inventory is numeric
        return mongoTemplate.find(query, Item.class);
    }

    //add dto
    @Override
    public List<Item> findByPurchaseLimitLessThan(int limit) {
        Query query = new Query();
        query.addCriteria(Criteria.where("purchaseLimit").lt(limit));
        return mongoTemplate.find(query, Item.class);
    }

    @Override
    public List<Item> findByInventoryMoreThanPurchaseLimit(){
        Query query = new Query();
        query.addCriteria(Criteria.where("inventory").gte("purchaseLimit"));
        return mongoTemplate.find(query, Item.class);
    }
}
