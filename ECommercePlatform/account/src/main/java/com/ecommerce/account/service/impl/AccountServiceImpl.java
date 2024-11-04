package com.ecommerce.account.service.impl;

import com.ecommerce.account.dao.AccountDao;
import com.ecommerce.account.entity.Account;
import com.ecommerce.account.payload.AccountDto;
import com.ecommerce.account.service.AccountService;
import com.ecommerce.account.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    private JwtUtil jwtUtil;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AccountServiceImpl(AccountDao accountDao, JwtUtil jwtUtil) {
        this.accountDao = accountDao;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AccountDto register(AccountDto accountDto) {
        return registerAccount(accountDto);
    }

    @Override
    public String login(AccountDto accountDto) {
        String userEmail = accountDto.getUserEmail();
        String password = accountDto.getPassword();
        AccountDto account = findByUserEmail(userEmail);
        if (verifyPassword(password, account.getPassword())) {
            return jwtUtil.generateToken(userEmail);
        }
        throw new RuntimeException("Wrong userEmail or password");
    }

    @Override
    public AccountDto registerAccount(AccountDto accountDto) {
        Account account = mapToEntity(accountDto);
        Account savedAccount = accountDao.save(account);
        return mapToDto(savedAccount);
    }

    @Override
    public AccountDto findByUserEmail(String userEmail) {
        Optional<Account> account = accountDao.findByUserEmail(userEmail);
        if (account.isPresent()) {
            return mapToDto(account.get());
        }
        throw new RuntimeException("userEmail does not exit");
    }

    @Override
    public boolean verifyPassword(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }

    private Account mapToEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setUserEmail(accountDto.getUserEmail());
        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        return account;
    }

    private AccountDto mapToDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setUserId(account.getUserId());
        accountDto.setUserEmail(account.getUserEmail());
        accountDto.setPassword(account.getPassword());
        return accountDto;
    }
}
