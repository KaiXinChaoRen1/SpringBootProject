package com.lwq.jk2_JPA.service.transactionalTest;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.lwq.jk2_JPA.dao.schoolRepository.PersonRepository;
import com.lwq.jk2_JPA.entity.schoolstory.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransactionalTestService {

    @Autowired
    XiushifuTest xiushifuTest;
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

    public void xiushifuTest() {
        try {
            xiushifuTest.publicadd2();
        } catch (Exception e) {
            log.error("hehe");
        }
        try {
            // xiushifuTest.privateadd2();
        } catch (Exception e) {
            log.error("hehe");
        }
        try {
            xiushifuTest.protectedadd2();
        } catch (Exception e) {
            log.error("hehe");
        }
        try {
            xiushifuTest.defaultdadd2();
        } catch (Exception e) {
            log.error("hehe");
        }
    }

    @Transactional
    public void publicadd2() {
        Person p1 = Person.builder().name("public").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
        if (true) {
            throw new RuntimeException();
        }
    }

    @Transactional
    private void privateadd2() {
        Person p1 = Person.builder().name("private").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
        if (true) {
            throw new RuntimeException();
        }
    }

    @Transactional
    protected void protectedadd2() {
        Person p1 = Person.builder().name("protected").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
        if (true) {
            throw new RuntimeException();
        }
    }

    @Transactional
    void defaultdadd2() {
        Person p1 = Person.builder().name("default").age(55).birthday(LocalDateTime.now()).build();
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

    public void addtest4(boolean isException) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(Person.builder().name("111").age(111).birthday(LocalDateTime.now()).build());
        arrayList.add(Person.builder().name("222").age(222).birthday(LocalDateTime.now()).build());

        pr.saveAll(arrayList);
        transactionManager.commit(status);
        // 新开一个事务
        TransactionStatus newStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            Person p1 = Person.builder().name("333").age(333).birthday(LocalDateTime.now()).build();
            pr.save(p1);
            if (isException) {
                throw new RuntimeException();
            }
            transactionManager.commit(newStatus);
        } catch (Exception e) {
            transactionManager.rollback(newStatus);
            throw e;
        }
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public void jdbcTemplateTest(Integer id, Boolean isException) {

        String sql = "UPDATE `t_person` SET NAME ='hehe' WHERE id=" + id;

        jdbcTemplate.execute(sql);

        if (isException) {
            throw new RuntimeException();
        }

    }

}
