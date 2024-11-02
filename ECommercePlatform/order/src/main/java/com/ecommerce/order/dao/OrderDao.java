package com.ecommerce.order.dao;

import com.ecommerce.order.entity.Order;
import com.ecommerce.order.entity.OrderEntityCompositeKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface OrderDao extends CassandraRepository<Order, OrderEntityCompositeKey> {
    List<Order> findById(int id);
    List<Order> findByIdAndName(int id, String name);
}
