package com.ecommerce.order.service.impl;

import com.ecommerce.item.controller.ItemController;
import com.ecommerce.item.service.ItemService;
import com.ecommerce.order.client.ItemClient;
import com.ecommerce.order.dao.OrderDao;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.payload.OrderDto;
import com.ecommerce.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    private ItemClient itemClient;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, ItemClient itemClient) {
        this.orderDao = orderDao;
        this.itemClient = itemClient;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = mapToEntity(orderDto);
        Order savedOrder = orderDao.save(order);
        return mapToDto(savedOrder);
    }

    @Override
    public List<OrderDto> findOrderById(int id) {
        List<Order> orders = orderDao.findById(id);
        return orders.stream().map(order -> mapToDto(order)).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findOrderByIdAndName(int id, String name) {
        List<Order> orders = orderDao.findByIdAndName(id, name);
        return orders.stream().map(order -> mapToDto(order)).collect(Collectors.toList());
    }

    private OrderDto mapToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setName(order.getName());
        orderDto.setItemName(order.getItemName());
        orderDto.setItem(Objects.requireNonNull(itemClient.findItemsByItemName(order.getItemName()).getBody()).get(0));
        return orderDto;
    }

    private Order mapToEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setName(orderDto.getName());
        order.setItemName(orderDto.getItemName());
        return order;
    }
}
