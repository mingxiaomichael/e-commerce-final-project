package com.ecommerce.account.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "userEmail", nullable = false)
    private String userEmail;
    @Column(name = "password", nullable = false)
    private String password;

    public Account() {
    }

    public Account(Long userId, String userEmail, String password) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
