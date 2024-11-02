package com.ecommerce.order.controller;

import com.ecommerce.order.dao.OrderDao;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.payload.OrderDto;
import com.ecommerce.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class orderController {
    private final OrderService orderService;

    @Autowired
    public orderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto response = orderService.createOrder(orderDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<OrderDto>> findOrderById(@PathVariable int id) {
        List<OrderDto> response = orderService.findOrderById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/idandname/{id}/{name}")
    public ResponseEntity<List<OrderDto>> findOrderByIdAndName(@PathVariable int id, @PathVariable String name) {
        List<OrderDto> response = orderService.findOrderByIdAndName(id, name);
        return ResponseEntity.ok(response);
    }
}
