package com.ecommerce.account.payload;


public class AccountDto {
    private Long userId;
    private String userEmail;
    private String password;

    public AccountDto() {
    }

    public AccountDto(Long userId, String userEmail, String password) {
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
        return "AccountDto{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
