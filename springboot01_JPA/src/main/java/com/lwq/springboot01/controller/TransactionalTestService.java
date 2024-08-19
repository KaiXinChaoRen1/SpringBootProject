package com.lwq.springboot01.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.lwq.springboot01.dao.schoolRepository.PersonRepository;
import com.lwq.springboot01.entity.schoolstory.Person;

@Service
public class TransactionalTestService {

    @Autowired
    private PersonRepository pr;

    @Autowired
    TransactionalTestService2 transactionalTestService2;

    @Transactional
    public void add1() {
        Person p1 = Person.builder().name("zhangfei").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
    }

    @Transactional
    public void add2() {
        Person p1 = Person.builder().name("zhangfei").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
        if (true) {
            throw new RuntimeException();
        }
    }

    @Transactional(noRollbackFor = RuntimeException.class)
    public void add3() {
        Person p1 = Person.builder().name("zhangfei").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
        if (true) {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void add4() {
        transactionalTestService2.add1();
        throw new RuntimeException();
    }

    @Transactional
    public void add5EQUIRES_NEW() {
        transactionalTestService2.add1REQUIRES_NEW();
        throw new RuntimeException();
    }

    @Transactional
    public void add6NESTED() {
        transactionalTestService2.add1NESTED();
        throw new RuntimeException();
    }

    @Transactional
    public void add7() {
        // 存在JpaDialect does not support savepoints保存点问题,不能这样子调用
        transactionalTestService2.add1NESTED();
        Person p1 = Person.builder().name("hehe").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
    }

    @Autowired
    PlatformTransactionManager transactionManager;

    public void addtest() {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            Person p1 = Person.builder().name("hehe").age(55).birthday(LocalDateTime.now()).build();
            pr.save(p1);
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }

    public void addtest2() {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            Person p1 = Person.builder().name("hehe").age(55).birthday(LocalDateTime.now()).build();
            pr.save(p1);
            transactionManager.commit(status);
            throw new RuntimeException();
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }

    public void addtest3() {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            Person p1 = Person.builder().name("hehe").age(55).birthday(LocalDateTime.now()).build();
            pr.save(p1);
            if (1 == 1) {
                throw new RuntimeException();
            }
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }

}
