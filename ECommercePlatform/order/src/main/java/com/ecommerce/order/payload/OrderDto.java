package com.ecommerce.order.payload;

import com.ecommerce.item.entity.Item;
import com.ecommerce.item.payload.ItemDto;

import java.util.List;

public class OrderDto {
    private Long userId;
    private Long orderId;
    private String orderName;
    private List<Long> itemId;

    public OrderDto() {
    }

    public OrderDto(Long userId, Long orderId, String orderName, List<Long> itemId) {
        this.userId = userId;
        this.orderId = orderId;
        this.orderName = orderName;
        this.itemId = itemId;
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

    public List<Long> getItemId() {
        return itemId;
    }

    public void setItemId(List<Long> itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "userId=" + userId +
                ", orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", itemId=" + itemId +
                '}';
    }
}
