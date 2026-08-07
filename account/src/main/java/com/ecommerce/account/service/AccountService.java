package com.ecommerce.account.service;

import com.ecommerce.account.entity.Account;
import com.ecommerce.account.payload.AccountDto;

import java.util.Optional;

public interface AccountService {
    AccountDto register(AccountDto accountDto);
    String login(AccountDto accountDto);
    AccountDto registerAccount(AccountDto accountDto);
    AccountDto findByUserEmail(String userEmail);
    boolean verifyPassword(String password, String encodedPassword);
}
