package com.ecommerce.payment.entity;

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



    @Column(nullable = false)
    private String paymentStatus;

    @Column(length = 16,nullable = false)
    private String paymentCard;

    @Column(nullable = false)
    private String cardExpiration;

    @Column(nullable = false)
    private int cvv;

    @Column(nullable = false)
    private String billingAddress;

    @Column(nullable = false)
    private int ZIP;

    @CreationTimestamp
    private LocalDateTime createDateTime;



    public Payment(){
    }

    public Payment(Long userId,  String paymentStatus, String paymentCard, String cardExpiration, int cvv, String billingAddress, int ZIP) {
        this.userId = userId;
        this.paymentStatus = paymentStatus;
        this.paymentCard = paymentCard;
        this.cardExpiration = cardExpiration;
        this.cvv = cvv;
        this.billingAddress = billingAddress;
        this.ZIP = ZIP;
        this.createDateTime = LocalDateTime.now();
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "Payment{" +
                "userId=" + userId +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentCard='" + paymentCard + '\'' +
                ", cardExpiration='" + cardExpiration + '\'' +
                ", cvv=" + cvv +
                ", billingAddress='" + billingAddress + '\'' +
                ", ZIP=" + ZIP +
                ", createDateTime=" + createDateTime +
                '}';
    }
}
