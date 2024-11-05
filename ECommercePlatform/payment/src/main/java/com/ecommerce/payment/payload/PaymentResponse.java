package com.ecommerce.payment.payload;

import java.time.LocalDateTime;

public class PaymentResponse {
    private long orderId;

    private String paymentStatus;

    private String paymentCard;

    private String billingAddress;

    private int ZIP;

    private LocalDateTime createDateTime;

    public PaymentResponse(long orderId, String paymentStatus, String paymentCard, String billingAddress, int ZIP, LocalDateTime createDateTime) {
        this.orderId = orderId;
        this.paymentStatus = paymentStatus;
        this.paymentCard = paymentCard;
        this.billingAddress = billingAddress;
        this.ZIP = ZIP;
        this.createDateTime = createDateTime;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(String paymentCard) {
        this.paymentCard = paymentCard;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public int getZIP() {
        return ZIP;
    }

    public void setZIP(int ZIP) {
        this.ZIP = ZIP;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }



}
