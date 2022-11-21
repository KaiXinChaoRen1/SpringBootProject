package com.lwq.springboot01;

import com.lwq.springboot01.Entity.schoolstory.HeadTeacher;
import com.lwq.springboot01.Entity.schoolstory.Student;
import com.lwq.springboot01.dao.schoolRepository.HeadTeacherRepository;
import com.lwq.springboot01.dao.schoolRepository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ManyToOne {
    @Autowired
    private StudentRepository sr;
    @Autowired
    private HeadTeacherRepository htr;




    //先存再查的方式可能会缓存,这里直接手动在数据库写数据,直接查,记得      ddl-auto: update
    @Commit
    @Transactional
    @Test
    public void name4() {
        Optional<HeadTeacher> byId = htr.findById(1);
        HeadTeacher headTeacher = byId.get();
        System.out.println("老师是" + headTeacher.getName());
        System.out.println("他的学生有" + headTeacher.getStudents());


    }

    //查多的一方没问题都能查到
    @Test
    public void name3() {
        HeadTeacher ht1 = HeadTeacher.builder().name("宗清广").build();
        List<Student> l = new ArrayList<>();
        Student s1 = Student.builder().name("李文强").ht(ht1).build();
        Student s2 = Student.builder().name("孔令健").ht(ht1).build();
        l.add(s1);
        l.add(s2);
        sr.saveAll(l);
        //添加好数据

        Optional<Student> byId = sr.findById(1);
        Student student = byId.get();
        System.out.println("学生是" + student.getName());
        System.out.println("他的老师是" + student.getHt().getName());

    }

    //自动生成的id会同步到内存的java对象中
    @Test
    public void name222() {
        HeadTeacher ht1 = HeadTeacher.builder().name("宗清广").build();

        Student s1 = Student.builder().name("李文强").ht(ht1).build();
        Student s2 = Student.builder().name("孔令健").ht(ht1).build();
        sr.save(s1);
        System.out.println(s1.getId());
        System.out.println(ht1);
    }

//    @Commit
//    @Transactional        //这样会生成两个ht
    public void name22() {
        HeadTeacher ht1 = HeadTeacher.builder().name("宗清广").build();
        Student s1 = Student.builder().name("李文强").ht(ht1).build();
        sr.save(s1);

        HeadTeacher ht2 = HeadTeacher.builder().name("宗清广").build();
        Student s2 = Student.builder().name("孔令健").ht(ht2).build();
        sr.save(s2);
    }


    @Commit
    @Transactional        //不加Transactional和@Commit就报错
    @Test
    public void name2() {
        HeadTeacher ht1 = HeadTeacher.builder().name("宗清广").build();

        Student s1 = Student.builder().name("李文强").ht(ht1).build();
        Student s2 = Student.builder().name("孔令健").ht(ht1).build();
        sr.save(s1);
        sr.save(s2);
    }

    //常规的维护外键方去操作
    @Test
    public void name1() {
        HeadTeacher ht1 = HeadTeacher.builder().name("宗清广").build();
        List<Student> l = new ArrayList<>();
        Student s1 = Student.builder().name("李文强").ht(ht1).build();
        Student s2 = Student.builder().name("孔令健").ht(ht1).build();
        l.add(s1);
        l.add(s2);
        sr.saveAll(l);
    }
    //上面的是操作Many的一方
    //*****************************************************************************
    //下面两个方法是操纵One的一方

    //类比OneToOne name222  student来维护外键,并保证确实维护了外键,即使用htr去save也生效
    @Test
    public void name00() {
        HeadTeacher ht1 = HeadTeacher.builder().name("尹建志").build();

        HashSet<Student> studentHashSet = new HashSet<Student>();
        Student s1 = Student.builder().name("李文强").ht(ht1).build(); //这里student维护了外键
        Student s2 = Student.builder().name("陈勇成").ht(ht1).build();
        studentHashSet.add(s1);
        studentHashSet.add(s2);

        ht1.setStudents(studentHashSet);                        //这里保证在存ht的时候也一起存student

        htr.save(ht1);
    }

    //One的一方已经放弃外键维护了,所以在ht1中加入set也没用,只能保证都存,但没有外键关系
    @Test
    public void name0() {
        HashSet<Student> set = new HashSet<Student>();
        Student s1 = Student.builder().name("李文强").build();
        Student s2 = Student.builder().name("陈勇成").build();
        set.add(s1);
        set.add(s2);

        HeadTeacher ht1 = HeadTeacher.builder().name("尹建志").students(set).build();
        htr.save(ht1);
    }
}
