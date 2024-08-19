package com.lwq.springboot01.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

}
