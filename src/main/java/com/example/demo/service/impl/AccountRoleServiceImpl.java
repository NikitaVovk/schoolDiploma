package com.example.demo.service.impl;

import com.example.demo.dao.AccountRoleDao;
import com.example.demo.domain.AccountRole;
import com.example.demo.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountRoleService")
@Transactional
public class AccountRoleServiceImpl implements AccountRoleService {

    @Autowired
    private AccountRoleDao accountRoleDao;

    @Override
    public String getRoleByIdac_Roles(Long id) {
        return accountRoleDao.findRoleById(id);
    }

    @Override
    public AccountRole findAcRoleById(Long id) {
        return accountRoleDao.findAcRoleById(id);
    }
}