package com.example.demo.dao;

import com.example.demo.domain.Account;

import java.util.List;

public interface AccountDao {
    Account findAccountByUsername(String username);
    Account findAccountByIdaccount(Long id);
    void editAccount(Account account);
    void addAccount(Account account);

}