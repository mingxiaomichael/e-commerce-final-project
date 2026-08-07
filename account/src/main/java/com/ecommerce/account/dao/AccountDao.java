package com.ecommerce.account.dao;

import com.ecommerce.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountDao extends JpaRepository<Account, Long> {
    Optional<Account> findByUserEmail(String userEmail);
}
