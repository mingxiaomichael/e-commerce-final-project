package com.ecommerce.payment.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="payments")
public class Payment {

    @Id
    @Column(nullable = false)
    private Long userId;

    @Column(length = 16,nullable = false)
    private String paymentCard;

    @Column(nullable = false)
    private String cardExpiration;

    @Column(nullable = false)
    private int cvv;

    @Column(nullable = false)
    private String billingAddress;

    @Column(nullable = false)
    private int zip;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    public Payment(){
    }

    public Payment(Long userId, String paymentCard, String cardExpiration, int cvv, String billingAddress, int zip) {
        this.userId = userId;
        this.paymentCard = paymentCard;
        this.cardExpiration = cardExpiration;
        this.cvv = cvv;
        this.billingAddress = billingAddress;
        this.zip = zip;
        this.createDateTime = LocalDateTime.now();
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime() {
        this.createDateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Payment{" +
                "userId=" + userId +
                ", paymentCard='" + paymentCard + '\'' +
                ", cardExpiration='" + cardExpiration + '\'' +
                ", cvv=" + cvv +
                ", billingAddress='" + billingAddress + '\'' +
                ", zip=" + zip +
                ", createDateTime=" + createDateTime +
                '}';
    }
}
