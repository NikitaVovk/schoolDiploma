package com.example.demo.service.impl;


import com.example.demo.dao.AccountDao;
import com.example.demo.dao.AccountRoleDao;
import com.example.demo.domain.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    AccountRoleDao accountRoleDao;



    @Override
    public Account findAccountByUsername(String username) {
        Account acc = accountDao.findAccountByUsername(username);
        if (acc == null) {
            System.out.println("not found");
        }
        return acc;
    }

    @Override
    public Account findAccountByIdaccount(Long id) {
        return accountDao.findAccountByIdaccount(id);
    }



    @Override
    public Long getLoggedAccountIdaccount(HttpSession session) {
        Long accountId = (Long) session.getAttribute("id");
        if (accountId == null) {
            System.out.println("not found");
        }
        return accountId;
    }

    @Override
    public void editAccount(Account account) {
        accountDao.editAccount(account);
    }

    @Override
    public void addAccount(Account account) {
        accountDao.addAccount(account);
    }

    @Override
    public void deleteAccount(Account account) {
        accountDao.deleteAccount(account);
    }


}