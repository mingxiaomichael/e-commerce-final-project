package com.ecommerce.order.entity;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.List;


@Table(value = "orders")
public class Order {
    @PrimaryKeyColumn(name = "userid", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Long userId;
    @PrimaryKeyColumn(name = "orderid", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private Long orderId;
    @Column("ordername")
    private String orderName;

    @Column("itemid")
    @CassandraType(type = CassandraType.Name.LIST, typeArguments = CassandraType.Name.BIGINT)
    private List<Long> itemId;

    @Column("orderstatus")
    private String orderStatus;

    public Order(Long userId, Long orderId, String orderName, List<Long> itemId, String orderStatus) {
        this.userId = userId;
        this.orderId = orderId;
        this.orderName = orderName;
        this.itemId = itemId;
        this.orderStatus = orderStatus;
    }

    public Order() {
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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userId=" + userId +
                ", orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", itemId=" + itemId +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
