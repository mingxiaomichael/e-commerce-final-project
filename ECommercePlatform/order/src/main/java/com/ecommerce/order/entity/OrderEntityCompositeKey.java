package com.ecommerce.order.entity;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;

@PrimaryKeyClass
public class OrderEntityCompositeKey implements Serializable {
    @PrimaryKeyColumn(name = "userId", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Long userId;
    @PrimaryKeyColumn(name = "orderId", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private Long orderId;

}
