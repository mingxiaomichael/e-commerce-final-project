package com.ecommerce.order.dao;

import com.ecommerce.order.entity.Order;
import com.ecommerce.order.entity.OrderEntityCompositeKey;
import com.ecommerce.order.payload.OrderDto;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface OrderDao extends CassandraRepository<Order, OrderEntityCompositeKey> {
    List<Order> findByUserId(Long userId);
    Order findByUserIdAndOrderId(Long userId,Long orderId);
}
