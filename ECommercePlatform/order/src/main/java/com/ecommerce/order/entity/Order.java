package com.ecommerce.order.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("orders")
public class Order {
    @PrimaryKey
    private OrderEntityCompositeKey key;
//    private int id;
//    private String name;

    public Order() {
    }

    public Order(OrderEntityCompositeKey key) {
        this.key = key;
    }
}
