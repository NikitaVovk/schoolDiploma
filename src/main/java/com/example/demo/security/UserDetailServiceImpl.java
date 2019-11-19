package com.example.demo.security;

import com.example.demo.domain.Account;
import com.example.demo.service.AccountRoleService;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRoleService accountRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account;
        String role;
        try{
            account = accountService.findAccountByUsername(username);
            role = accountRoleService.getRoleByIdac_Roles(account.getAccountRole().getId());
        }catch (RuntimeException e){
            throw new UsernameNotFoundException("username was not found in the database");
        }
        return new AccountUserDetails(account, role);
    }
}
