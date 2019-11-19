package com.example.demo.dao;

import com.example.demo.domain.AccountRole;

public interface AccountRoleDao {
    String findRoleById(Long id);
    AccountRole getRoleByName(String role);
}
