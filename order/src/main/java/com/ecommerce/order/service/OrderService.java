package com.ecommerce.order.service;

import com.ecommerce.order.entity.Order;
import com.ecommerce.order.payload.OrderDto;
import com.ecommerce.order.payload.OrderResponse;
import com.ecommerce.payment.payload.MakePaymentResponse;
import com.ecommerce.payment.payload.PaymentDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(Long userId, OrderDto order);
    List<OrderDto> findAll(Long userId);
    OrderDto findOrderByOrderId(Long userId,Long orderId);
    OrderResponse processOrder(PaymentDto paymentDto);

}
