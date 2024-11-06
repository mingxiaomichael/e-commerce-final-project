package com.ecommerce.account.payload;

public class LoginResponse {
    private Long userId;
    private String userEmail;
    private String JwtToken;

    public LoginResponse() {
    }

    public LoginResponse(Long userId, String userEmail, String jwtToken) {
        this.userId = userId;
        this.userEmail = userEmail;
        JwtToken = jwtToken;
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

    public String getJwtToken() {
        return JwtToken;
    }

    public void setJwtToken(String jwtToken) {
        JwtToken = jwtToken;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", JwtToken='" + JwtToken + '\'' +
                '}';
    }
}
