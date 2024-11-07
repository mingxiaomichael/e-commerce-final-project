package com.ecommerce.order.service;

import com.ecommerce.order.entity.Order;
import com.ecommerce.order.payload.OrderDto;
import com.ecommerce.payment.payload.MakePaymentResponse;
import com.ecommerce.payment.payload.PaymentDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto order);
    List<OrderDto> findAll(Long userId);
    OrderDto findOrderByOrderId(Long userId,Long orderId);

    MakePaymentResponse processOrder(PaymentDto paymentDto);

}
