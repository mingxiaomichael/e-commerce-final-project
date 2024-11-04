package com.ecommerce.account.controller;

import com.ecommerce.account.entity.Account;
import com.ecommerce.account.payload.AccountDto;
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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AccountDto accountDto) {
        String token = jwtUtil.generateToken(accountDto.getUserEmail());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<AccountDto> register(@RequestBody AccountDto accountDto) {
        AccountDto response = accountService.register(accountDto);
        return ResponseEntity.ok(response);
    }
}
