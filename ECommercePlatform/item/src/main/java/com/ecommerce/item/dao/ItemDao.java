package com.ecommerce.item.dao;

import com.ecommerce.item.entity.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ItemDao extends MongoRepository<Item, ObjectId> {
    List<Item> findByName(String name);
}
