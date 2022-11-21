package com.lwq.springboot01;

import com.lwq.springboot01.Entity.schoolstory.Person;
import com.lwq.springboot01.dao.schoolRepository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class One {
    @Autowired
    private PersonRepository pr;

    @Commit
    @Transactional
    @Test
    public void name6(){
        Person p1 = Person.builder().name("lwq").age(55).build();
        pr.save(p1);
        System.out.println(p1);     //数据库的修改会同步到内存中的java对象
        p1.setName("www");          //session内java对象修改会同步到数据库
    }

    @Commit
    @Transactional
    @Test
    public void name5(){
        Person p1 = Person.builder().id(1).name("lwq").age(55).build();
        pr.save(p1);
        System.out.println(p1);     //数据库的修改会同步到内存中的java对象
        p1.setName("www");          //session内java对象修改会同步到数据库(手动加的id保存的对象就不会同步)
    }


    @Test
    public void name4(){
        Person p1 = Person.builder().id(1).name("lwq").age(55).build();
        Person psave = pr.save(p1);
        Person p2 = Person.builder().id(1).name("lwq2").age(55).build();
        pr.save(p2);

    }
    @Test
    public void name3(){
        Person p1 = Person.builder().id(1).name("zhangfei").age(55).build();
        pr.save(p1);
        Person p2 = Person.builder().id(1).name("zhangfei").age(55).build();
        pr.delete(p2);
    }

    @Test
    public void name2(){
        Person p1 = Person.builder().id(1).name("zhangfei").age(55).build();
        pr.save(p1);
        Person p2 = Person.builder().id(1).build();
        pr.delete(p2);
    }

    @Test
    public void name1(){
        Person p1 = Person.builder().name("zhangfei").age(55).build();
        pr.save(p1);
    }
}
