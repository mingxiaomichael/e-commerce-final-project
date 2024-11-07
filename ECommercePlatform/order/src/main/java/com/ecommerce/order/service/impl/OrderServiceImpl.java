package com.ecommerce.order.service.impl;

import com.ecommerce.item.controller.ItemController;
import com.ecommerce.item.dao.ItemDao;
import com.ecommerce.item.entity.Item;
import com.ecommerce.item.payload.ItemDto;
import com.ecommerce.item.service.ItemService;
import com.ecommerce.order.client.ItemClient;
import com.ecommerce.order.client.PaymentClient;
import com.ecommerce.order.dao.OrderDao;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.payload.OrderDto;
import com.ecommerce.order.payload.OrderResponse;
import com.ecommerce.order.service.OrderService;
import com.ecommerce.payment.entity.Payment;
import com.ecommerce.payment.payload.MakePaymentResponse;
import com.ecommerce.payment.payload.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    private ItemClient itemClient;

    private PaymentClient paymentClient;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, ItemClient itemClient, PaymentClient paymentClient) {
        this.orderDao = orderDao;
        this.itemClient = itemClient;
        this.paymentClient = paymentClient;
    }

    @Override
    public OrderDto createOrder(Long userId, OrderDto orderDto) {
        Order order = mapToEntity(orderDto);
        order.setUserId(userId);
        order.setOrderStatus("UNPAID");
        Order savedOrder = orderDao.save(order);
        return mapToDto(savedOrder);
    }

    @Override
    public List<OrderDto> findAll(Long userId){
        List<Order> orderList= orderDao.findByUserId(userId);
        return orderList.stream().map(order -> mapToDto(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDto findOrderByOrderId(Long userId, Long orderId) {
        Order order = orderDao.findByUserIdAndOrderId(userId, orderId);
        return mapToDto(order);
    }

    @Override
    public OrderResponse processOrder(PaymentDto paymentDto){
        // update orderStatus based on payment status from payment dto
        MakePaymentResponse madePayment = paymentClient.makePayment(paymentDto).getBody();
        Long orderId =  madePayment.getOrderId();
        Long userId = madePayment.getUserId();
        String paymentStatus = madePayment.getPaymentStatus();
        if (paymentStatus.equals("PAID")) {
            Order orderFromDB = orderDao.findByUserIdAndOrderId(userId, orderId);
            orderFromDB.setOrderStatus(paymentStatus);
            orderDao.save(orderFromDB);
            // Decrease the inventory of the item
            for(Long item : orderFromDB.getItemId()){
                ItemDto itemTemp = itemClient.findByItemID(item).getBody();
                Long itemIdTemp = itemTemp.getItemID();
                itemTemp.setInventory(itemTemp.getInventory() - 1);
                itemClient.updateItem(itemIdTemp, itemTemp);
            }
        }
        Order orderFromDB1 = orderDao.findByUserIdAndOrderId(userId, orderId);
        OrderResponse response = mapToOrderResponse(orderFromDB1, madePayment);
        return response;
    }


    private OrderDto mapToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getOrderId());
        orderDto.setOrderName(order.getOrderName());
        orderDto.setItemId(order.getItemId());
        return orderDto;
    }

    private Order mapToEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderId(orderDto.getOrderId());
        order.setOrderName(orderDto.getOrderName());
        order.setItemId(orderDto.getItemId());
        return order;
    }

    private OrderResponse mapToOrderResponse(Order order, MakePaymentResponse makePaymentResponse) {
        OrderResponse response = new OrderResponse();
        response.setUserId(makePaymentResponse.getUserId());
        response.setOrderId(makePaymentResponse.getOrderId());
        response.setOrderName(order.getOrderName());
        response.setItemList(new ArrayList<>());
        List<Long> itemList = order.getItemId();
        for (Long item : itemList) {
            ItemDto itemTemp = itemClient.findByItemID(item).getBody();
            response.getItemList().add(itemTemp);
        }
        return response;
    }
}
