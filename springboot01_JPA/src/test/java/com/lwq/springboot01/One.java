package com.lwq.springboot01;

import com.lwq.springboot01.dao.schoolRepository.PersonRepository;
import com.lwq.springboot01.entity.schoolstory.Person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.annotations.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

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
       // pr.insertMap(dataList);
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
    public void name1211111() {
        Integer id=1;
        Optional<Person> byId = pr.findById(id);
        Person orElseThrow = byId.orElseThrow(()->new RuntimeException("在数据库中根据id"+id+"未找到记录"));
        orElseThrow.setAge(222);
        //没有事务则不行
    }
    @Test
    @Transactional
    @Commit
    public void name1211() {

        Integer id=1;
        Optional<Person> byId = pr.findById(id);
        Person orElseThrow = byId.orElseThrow(()->new RuntimeException("在数据库中根据id"+id+"未找到记录"));
        orElseThrow.setAge(333);
        //事务内 无需save也能修改
    }

    @Test
    @Transactional
    @Commit
    public void name121() {

        Integer id=1;
        Optional<Person> byId = pr.findById(id);
        Person orElseThrow = byId.orElseThrow(()->new RuntimeException("在数据库中根据id"+id+"未找到记录"));
        orElseThrow.setAge(100);
        pr.save(orElseThrow);
    }

    //在测试数据层时，可以在测试方法上添加 @Transactional 注解，这样测试方法中的所有数据库操作都会在事务中执行，执行完毕后会自动回滚，不会对数据库造成影响。
    @Test
    @Transactional
    public void name11() {

        Integer id=1;
        Optional<Person> byId = pr.findById(id);
        Person orElseThrow = byId.orElseThrow(()->new RuntimeException("在数据库中根据id"+id+"未找到记录"));
        orElseThrow.setAge(100);
        pr.save(orElseThrow);
    }

    

    @Test
    public void name1() {
        Person p1 = Person.builder().name("zhangfei").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
    }

    @Test
    public void name112() {
       //Person byName = pr.findByName("zhangfei");
       Optional<Person> byNameOptional = pr.findByName("zhangfei");
       System.out.println("=======================");
       System.out.println(byNameOptional);
       System.out.println("=======================");

    }
}
