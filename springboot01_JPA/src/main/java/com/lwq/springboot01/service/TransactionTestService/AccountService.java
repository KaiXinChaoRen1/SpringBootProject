package com.lwq.springboot01.service.TransactionTestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwq.springboot01.Entity.TransactionTestEntity.Account;
import com.lwq.springboot01.dao.TransactionTestRepository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void addAccount() throws Exception {
        //这里try-catch之后不会回滚
        Account newAccount = Account.builder().id(1L).accountNum(1001L).build();
        accountRepository.save(newAccount);
        userService.addUser();

    }

}
