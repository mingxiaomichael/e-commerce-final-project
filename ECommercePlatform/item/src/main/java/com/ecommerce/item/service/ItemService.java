package com.ecommerce.item.service;

import com.ecommerce.item.dao.ItemDao;
import com.ecommerce.item.entity.Item;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemDao itemDao;

    public Item saveItem(Item item) {
        return itemDao.save(item);
    }

    public List<Item> findItemsByName(String name) {
        return itemDao.findByName(name);
    }
}
