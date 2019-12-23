package com.example.demo.dao.impl;


import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.AccountDao;
import com.example.demo.domain.Account;
import org.hibernate.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Transactional
@Repository("accountDao")
public class AccountDaoImpl extends AbstractDao<Long, Account> implements AccountDao {

    @Override
    public Account findAccountByUsername(String username) {
        Query query = createQuery("from Account where USERNAME =:username");
        query.setParameter("username", username);
        return (Account) query.uniqueResult();
    }

    @Override
    public Account findAccountByIdaccount(Long id) {
        return getByKey(id);
    }

    @Override
    public void editAccount(Account account) {
        update(account);
    }

    @Override
    public void addAccount(Account account) {
        persist(account);
    }

    @Override
    public void deleteAccount(Account account) {
        delete(account);
    }


}