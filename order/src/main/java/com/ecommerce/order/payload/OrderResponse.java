package com.ecommerce.order.payload;

import com.ecommerce.item.payload.ItemDto;

import java.util.List;

public class OrderResponse {
    private Long userId;
    private Long orderId;
    private String orderName;
    private String orderStatus;
    private List<ItemDto> itemList;

    public OrderResponse(){}

    public OrderResponse(Long userId, Long orderId, String orderName, String orderStatus, List<ItemDto> itemList) {
        this.userId = userId;
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderStatus = orderStatus;
        this.itemList = itemList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<ItemDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDto> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "userId=" + userId +
                ", orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", itemList=" + itemList +
                '}';
    }
}
