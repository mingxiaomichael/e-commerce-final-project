package com.ecommerce.item.dao;

import com.ecommerce.item.entity.Item;
import com.ecommerce.item.payload.ItemDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ItemDao extends MongoRepository<Item, ObjectId> {
    /*findAll()*/

    List<Item> findByItemName(String itemName);
    List<Item> findByCategory(String category);
    List<Item> findByItemNameAndCategory(String itemName, String category);

}
