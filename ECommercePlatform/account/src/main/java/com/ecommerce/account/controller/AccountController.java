package com.ecommerce.account.controller;

import com.ecommerce.account.payload.AccountDto;
import com.ecommerce.account.payload.LoginResponse;
import com.ecommerce.account.security.JwtUtil;
import com.ecommerce.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;
    private JwtUtil jwtUtil;

    @Autowired
    public AccountController(AccountService accountService, JwtUtil jwtUtil) {
        this.accountService = accountService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<AccountDto> register(@RequestBody AccountDto accountDto) {
        AccountDto response = accountService.register(accountDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody AccountDto accountDto) {
        String token = accountService.login(accountDto);
        Long userId = jwtUtil.extractUserId(token);
        String userEmail = jwtUtil.extractUserEmail(token);
        LoginResponse response = new LoginResponse(userId, userEmail, token);
        return ResponseEntity.ok(response);
    }

}
