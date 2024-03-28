package com.lwq.springboot01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.springboot01.dao.TransactionTestRepository.AccountRepository;
import com.lwq.springboot01.dao.TransactionTestRepository.UserRepository;
import com.lwq.springboot01.entity.transactionTestEntity.Account;
import com.lwq.springboot01.entity.transactionTestEntity.User;
import com.lwq.springboot01.service.TransactionTestService.AccountService;
import com.lwq.springboot01.service.TransactionTestService.UserService;



@RestController
@RequestMapping("tran")
public class TransactionTestController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @GetMapping("/add")
    public String add() {
        try {
            accountService.addAccount();
            return "添加成功";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    /**
     * 编程式事务
     */
    @GetMapping("/add2")
    public String add2() {
        try {
            transactionTemplate.execute(t -> {
                Account newAccount = Account.builder().id(1L).accountNum(1001L).build();
                accountRepository.save(newAccount);
                userService.addUser();
                return null;
            });
            return "添加成功";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/get")
    public String get() {
        try {
            List<Account> allAccount = accountRepository.findAll();
            List<User> allUser = userRepository.findAll();
            accountRepository.deleteAll();
            userRepository.deleteAll();
            return "注册账户的数量为" + allAccount.size() + ",用户的数量为" + allUser.size() + ",but,现在都删除了";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
