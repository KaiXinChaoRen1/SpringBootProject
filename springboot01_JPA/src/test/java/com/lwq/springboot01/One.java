package com.lwq.springboot01;

import com.lwq.springboot01.Entity.schoolstory.Person;
import com.lwq.springboot01.dao.schoolRepository.PersonRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class One {
    @Autowired
    private PersonRepository pr;


    @Test
    public void name6() {
        List<Map<String, Object>> dataList =new ArrayList<>();
        HashMap<String, Object> hashMap = new HashMap<String,Object>();
        hashMap.put("id", "111");
        hashMap.put("name","aaa" );
        HashMap<String, Object> hashMap2 = new HashMap<String,Object>();
        hashMap.put("id", "222");
        hashMap.put("name","bbb" );
        dataList.add(hashMap);
        dataList.add(hashMap2);
        pr.insertMap(dataList);


    }


    //JPQL
    @Test
    public void name5() {
        String name= pr.jpqlQuery(1);
        System.out.println(name);

    }


    @Test
    public void name4() {
        Person p1 = Person.builder().id(1).name("lwq").age(55).build();
        pr.save(p1);
        Person p2 = Person.builder().id(1).name("lwq2").age(55).build();
        pr.save(p2);
    }

    @Test
    public void name3() {
        Person p1 = Person.builder().id(1).name("zhangfei").age(55).build();
        pr.save(p1);
        Person p2 = Person.builder().id(1).name("zhangfei").age(55).build();
        pr.delete(p2);
    }

    @Test
    public void name2() {
        Person p1 = Person.builder().id(1).name("zhangfei").age(55).build();
        pr.save(p1);
        Person p2 = Person.builder().id(1).build();
        pr.delete(p2);
    }

    @Test
    public void name1() {
        Person p1 = Person.builder().name("zhangfei").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
    }
}
