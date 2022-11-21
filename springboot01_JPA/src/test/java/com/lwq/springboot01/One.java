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



    //session内对java对象修改会自动同步到数据库
    @Transactional
    @Commit
    @Test
    public void name5(){
        Person p1 = Person.builder().name("lwq").age(55).build();
        pr.save(p1);
        System.out.println(p1);     //数据库生成的id会同步到java对象
        Person person = pr.findById(1).get();
        person.setName("lwq2");     //查看数据库发现session内java对象的修改会同步到数据库
    }


    //这样可以正常修改
    @Test
    public void name4(){
        Person p1 = Person.builder().id(1).name("lwq").age(55).build();
        pr.save(p1);
        Person p2 = Person.builder().id(1).name("lwq2").age(55).build();
        pr.save(p2);

    }

    //delete是根据id来删除的
    //    delete
    //    from
    //        lwq_person
    //    where
    //        id=?
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
        System.out.println(p1);  //自动生成的id会自动同步到内存里的java对象中
    }
}
