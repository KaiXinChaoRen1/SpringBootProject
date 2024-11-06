package com.lwq.springboot01.service.transactionalTest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwq.springboot01.dao.schoolRepository.PersonRepository;
import com.lwq.springboot01.entity.schoolstory.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class XiushifuTest {
    @Autowired
    private PersonRepository pr;

    @Transactional
    public void publicadd2() {
        Person p1 = Person.builder().name("public").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
        if (true) {
            throw new RuntimeException();
        }
    }

    // @Transactional
    // private void privateadd2() {
    // Person p1 =
    // Person.builder().name("private").age(55).birthday(LocalDateTime.now()).build();
    // pr.save(p1);
    // if (true) {
    // throw new RuntimeException();
    // }
    // }

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
}
