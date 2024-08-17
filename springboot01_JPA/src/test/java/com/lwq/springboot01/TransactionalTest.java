package com.lwq.springboot01;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.lwq.springboot01.dao.schoolRepository.PersonRepository;
import com.lwq.springboot01.entity.schoolstory.Person;

@SpringBootTest
public class TransactionalTest {
    @Autowired
    private PersonRepository pr;


    /**
     * 测试回滚
     */
    @Test
    @Transactional
    @Commit
    public void name12() {
        newSave ();
        throw new RuntimeException("");
    }

    @Test
    @Transactional
    @Commit
    public void name1() {
        newSave ();
    }

    @Transactional
    public void newSave(){
        Person p1 = Person.builder().name("zhangfei").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
    }
}
