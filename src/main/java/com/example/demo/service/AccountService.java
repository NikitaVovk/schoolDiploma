package com.example.demo.service;

import com.example.demo.domain.Account;

import javax.servlet.http.HttpSession;

public interface AccountService {
    Account findAccountByUsername(String username);
    Account findAccountByIdaccount(Long id);
    Long getLoggedAccountIdaccount(HttpSession session);
    void editAccount(Account account);
    void addAccount(Account account);
    void deleteAccount(Account account);
}
