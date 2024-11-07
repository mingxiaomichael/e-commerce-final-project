package com.ecommerce.order.controller;

import com.ecommerce.order.payload.OrderDto;
import com.ecommerce.order.payload.OrderResponse;
import com.ecommerce.order.service.OrderService;
import com.ecommerce.order.security.JwtUtil;
import com.ecommerce.payment.payload.PaymentDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class orderController {
    private final OrderService orderService;
    private HttpServletRequest request;
    private JwtUtil jwtUtil;

    @Autowired
    public orderController(OrderService orderService, HttpServletRequest request, JwtUtil jwtUtil) {
        this.orderService = orderService;
        this.request = request;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        String token = jwtUtil.getJwtToken(request);
        Long userId = jwtUtil.extractUserId(token);
        OrderDto response = orderService.createOrder(userId, orderDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/findAllOrders")
    public ResponseEntity<List<OrderDto>> findAll() {
        String token = jwtUtil.getJwtToken(request);
        Long userId = jwtUtil.extractUserId(token);
        List<OrderDto> response = orderService.findAll(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> findOrderByOrderId(@PathVariable Long orderId) {
        String token = jwtUtil.getJwtToken(request);
        Long userId = jwtUtil.extractUserId(token);
        OrderDto response = orderService.findOrderByOrderId(userId, orderId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/processOrder")
    public ResponseEntity<OrderResponse> processOrder(@RequestBody PaymentDto paymentDto) {
        OrderResponse response = orderService.processOrder(paymentDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
