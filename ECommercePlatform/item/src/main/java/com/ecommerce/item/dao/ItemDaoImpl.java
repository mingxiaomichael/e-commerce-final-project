package com.ecommerce.item.dao;

import com.ecommerce.item.entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDaoImpl implements ItemDao{
    private EntityManager entityManager;

    @Autowired
    public ItemDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Item getItemById(int id) {
        return entityManager.find(Item.class, id);
    }

    @Override
    public Item createItem(Item item) {
        return entityManager.merge(item);
    }
}
