package com.ecommerce.order.controller;

import com.ecommerce.order.dao.OrderDao;
import com.ecommerce.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class orderController {
    private final OrderDao orderDao;

    @Autowired
    public orderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderDao.save(order);
    }

    @GetMapping("/{name}")
    public List<Order> findByIdAndName(@PathVariable String name) {
        return orderDao.findByName(name);
    }

    @GetMapping()
    public List<Order> findAll() {
        return orderDao.findAll();
    }
}
