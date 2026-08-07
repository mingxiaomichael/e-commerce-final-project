package com.ecommerce.payment.payload;

import java.time.LocalDateTime;

public class CreatePaymentMethodResponse {
    private long orderId;

    private String paymentStatus;

    private String paymentCard;

    private String billingAddress;

    private int zip;

    public CreatePaymentMethodResponse() {
    }

    public CreatePaymentMethodResponse(long orderId, String paymentStatus, String paymentCard, String billingAddress, int zip) {
        this.orderId = orderId;
        this.paymentStatus = paymentStatus;
        this.paymentCard = paymentCard;
        this.billingAddress = billingAddress;
        this.zip = zip;
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
        return zip;
    }

    public void setZIP(int ZIP) {
        this.zip = ZIP;
    }

}
