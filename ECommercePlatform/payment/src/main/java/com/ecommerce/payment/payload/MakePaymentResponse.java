package com.ecommerce.payment.payload;

public class MakePaymentResponse {
    private Long userId;
    private Long orderId;
    private String paymentStatus;

    public MakePaymentResponse() {
    }

    public MakePaymentResponse(Long userId, Long orderId, String paymentStatus) {
        this.userId = userId;
        this.orderId = orderId;
        this.paymentStatus = paymentStatus;
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

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "MakePaymentResponse{" +
                "userId=" + userId +
                ", orderId=" + orderId +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
