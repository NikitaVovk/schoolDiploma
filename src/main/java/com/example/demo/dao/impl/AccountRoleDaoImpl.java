package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractDao;
import com.example.demo.dao.AccountRoleDao;
import com.example.demo.domain.AccountRole;
import org.hibernate.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("accountRoleDao")
public class AccountRoleDaoImpl extends AbstractDao<Long, AccountRole> implements AccountRoleDao {
    @Override
    public String findRoleById(Long id) {
        return getByKey(id).getRole();
    }

    @Override
    public AccountRole getRoleByName(String role) {
        Query query = createQuery("from AccountRole where ROLE =:role");
        query.setParameter("role", role);
        return (AccountRole) query.uniqueResult();
    }
}
