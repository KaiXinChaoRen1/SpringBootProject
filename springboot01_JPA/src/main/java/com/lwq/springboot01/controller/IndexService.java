package com.lwq.springboot01.controller;

import java.util.ArrayList;
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
    public void batchInsert(List<Person> entities) {
        for (Person entity : entities) {
            entityManager.persist(entity);
            if (entities.indexOf(entity) % BATCH_SIZE == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        if (!entities.isEmpty()) {
            entityManager.flush();
            entityManager.clear();
        }
    }
}
