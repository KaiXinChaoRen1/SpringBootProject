package com.lwq.springboot01;


import com.lwq.springboot01.dao.schoolRepository.HeadTeacherRepository;
import com.lwq.springboot01.dao.schoolRepository.PersonRepository;
import com.lwq.springboot01.dao.schoolRepository.StudentRepository;
import com.lwq.springboot01.entity.schoolstory.HeadTeacher;
import com.lwq.springboot01.entity.schoolstory.Person;
import com.lwq.springboot01.entity.schoolstory.Student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

/**
 * JPA实体的状态
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StateTest {

    @Autowired
    private PersonRepository pr;
    @Autowired
    private StudentRepository sr;
    @Autowired
    private HeadTeacherRepository htr;




    //*********************下面的内容前提是id自动生成*****************************
    @Commit
    @Transactional
    @Test
    public void name6() {
        HeadTeacher ht1 = HeadTeacher.builder().name("宗清广").build();
        Student s1 = Student.builder().name("李文强").ht(ht1).build();
        sr.save(s1);
        //防止游离对象的产生,要保证是从数据库中拿到的
        HeadTeacher ht2 = htr.findById(1).get();
        ht2.setName("hehe");
        System.out.println(ht2);

        Student s2 = Student.builder().name("李文强").ht(ht2).build();
        sr.save(s2);
    }

    @Commit
    @Transactional
    @Test
    public void name5() {
        HeadTeacher ht1 = HeadTeacher.builder().name("宗清广").build();
        Student s1 = Student.builder().name("李文强").ht(ht1).build();
        sr.save(s1);
        //即使在session中也有可能出现这个错误,比如前端传入的,或者放在缓存集合中的游离对象
        //模拟一个id一样的,作为游离对象而不是瞬时对象
        HeadTeacher ht2 = HeadTeacher.builder().id(1).name("hehe").build();
        System.out.println(ht2);
        System.out.println(ht2.equals(ht1));

        Student s2 = Student.builder().name("李文强").ht(ht2).build();
        sr.save(s2);
    }

    @Commit
    @Transactional  //加上事务session不会关闭
    @Test
    public void name555() {
        HeadTeacher ht1 = HeadTeacher.builder().name("宗清广").build();
        Student s1 = Student.builder().name("李文强").ht(ht1).build();
        sr.save(s1);//这里session关闭
        //session关闭变成游离对象
        Student s2 = Student.builder().name("李文强").ht(ht1).build();
        sr.save(s2);
    }
    //***********************************************************************************





    //********************************下面是持久态相关问题*************************************
    @Commit
    @Transactional
    @Test
    public void name33() {
        //创建对象加入id
        Person p1 = Person.builder().id(11111).name("lwqq").age(55).build();
        pr.save(p1);   //id相同算修改,id不同算新增    
    }

    @Commit
    @Transactional
    @Test
    public void name3() {
        //创建对象加入id
        Person p1 = Person.builder().id(10086).name("lwq").age(55).build();
        //接收持久对象,又可以同步了
        Person p2 = pr.save(p1);
        System.out.println(p1);
        p2.setName("www");
    }

    
    @Commit
    @Transactional
    @Test
    public void name111() {
        //创建对象的时候添加上id,同步就不行了,而且如果设置了自动生成id,你在给加上id居然覆盖不了
        Person p1 = Person.builder().id(199).name("lwq").age(55).build();
        pr.save(p1);
        System.out.println(p1);         
        p1.setName("www");        
    }

    @Commit
    @Transactional
    @Test
    public void name11() {
        Person p1 = Person.builder().name("lwq").age(55).build();
        pr.save(p1);
        System.out.println(p1);
        p1.setName("www");              //这里就同步到数据库了,而不是方法的最后
        Person p2 = pr.findById(1).get();
        System.out.println(p2);
    }


    @Commit
    @Transactional
    @Test
    public void name1() {
        Person p1 = Person.builder().name("lwq").age(55).build();
        pr.save(p1);
        System.out.println(p1);          //数据库的修改会同步到内存中的java对象
        p1.setName("www");          //session内java对象修改会同步到数据库
    }
}
