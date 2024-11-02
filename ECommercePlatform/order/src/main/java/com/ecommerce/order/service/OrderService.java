package com.ecommerce.order.service;

import com.ecommerce.order.entity.Order;
import com.ecommerce.order.payload.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto order);
    List<OrderDto> findOrderById(int id);
    List<OrderDto> findOrderByIdAndName(int id, String name);
}
