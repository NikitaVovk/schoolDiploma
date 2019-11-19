package com.example.demo.service;

import com.example.demo.domain.Account;

import javax.servlet.http.HttpSession;

public interface AccountService {
    Account findAccountByUsername(String username);
    Account findAccountByIdaccount(Long id);
    Long getLoggedAccountIdaccount(HttpSession session);

}
