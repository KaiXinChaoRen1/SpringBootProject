package com.lwq.springboot01.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwq.springboot01.dao.schoolRepository.PersonRepository;
import com.lwq.springboot01.entity.schoolstory.Person;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IndexService {
    @Autowired
    private PersonRepository pr;

    @Transactional
    public void addNum(Integer num) {

        List<Person> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Person person = new Person();
            // person.setId(i);
            person.setIndexedUuid(UUID.randomUUID().toString());
            person.setUnindexedUuid(UUID.randomUUID().toString());
            list.add(person);
        }
        pr.saveAll(list);

    }

    private static final int BATCH_SIZE = 50;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public <S extends Object> List<S> insertAll(Iterable<S> entities) {
        Iterator<S> iterator = entities.iterator();
        List<S> list = new ArrayList<S>();

        int index = 0;
        while (iterator.hasNext()) {
            S next = iterator.next();
            entityManager.persist(next);

            index++;
            if (index % BATCH_SIZE == 0) {
                entityManager.flush(); // 将所有Managed状态的Entity实例同步到数据库；
                entityManager.clear(); // 将所有的Entity实例状态转至Detached状态；
            }

            list.add(next);
        }
        if (index % BATCH_SIZE != 0) {
            entityManager.flush();
            entityManager.clear();
        }

        return list;
    }
}
