package com.ecommerce.payment.payload;

import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class PaymentDto {

    //private Long userId;

    private long orderId;

    private String paymentCard;

    private String cardExpiration;

    private int cvv;

    private String billingAddress;

    private int zip;


    public PaymentDto(){}

    public PaymentDto(long orderId, String paymentCard, String cardExpiration, int cvv, String billingAddress, int zip) {
        this.orderId = orderId;
        this.paymentCard = paymentCard;
        this.cardExpiration = cardExpiration;
        this.cvv = cvv;
        this.billingAddress = billingAddress;
        this.zip = zip;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(String paymentCard) {
        this.paymentCard = paymentCard;
    }

    public String getCardExpiration() {
        return cardExpiration;
    }

    public void setCardExpiration(String cardExpiration) {
        this.cardExpiration = cardExpiration;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
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

    public void setZIP(int zip) {
        this.zip = zip;
    }



    @Override
    public String toString() {
        return "PaymentDto{" +
                "orderId=" + orderId +
                ", paymentCard='" + paymentCard + '\'' +
                ", cardExpiration='" + cardExpiration + '\'' +
                ", cvv=" + cvv +
                ", billingAddress='" + billingAddress + '\'' +
                ", zip=" + zip +
                '}';
    }
}
