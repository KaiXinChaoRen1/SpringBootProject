package com.lwq.springboot01;

import com.lwq.springboot01.Entity.Student;
import com.lwq.springboot01.Entity.StudentId;
import com.lwq.springboot01.dao.StudentIdRepository;
import com.lwq.springboot01.dao.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class OneToOne {
    @Autowired
    private StudentIdRepository sidr;
    @Autowired
    private StudentRepository sr;

    //查询学号,也有学生信息
    @Test
    public void name10() {
        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("其他信息").build();
        Student s1 = Student.builder().name("李文强").sid(sid1).build();
        sr.save(s1);

        Optional<StudentId> byId = sidr.findById(1);
        StudentId studentId = byId.get();
        System.out.println("学号是" + studentId.getStudentIdNumber());
        System.out.println("学号对应的学生是" + studentId.getStudent().getName());
    }

    //查询学生带着学号信息
    @Test
    public void name9() {
        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("其他信息").build();
        Student s1 = Student.builder().name("李文强").sid(sid1).build();
        sr.save(s1);

        Optional<Student> byId = sr.findById(1);
        Student student = byId.get();
        System.out.println("学生是" + student.getName());
        System.out.println("学生对应的学号是" + student.getSid().getStudentIdNumber());


    }

    //被拥有方设置级联操作后也可以级联删除
    @Test
    public void name6() {
        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("其他信息").build();
        Student s1 = Student.builder().name("李文强").sid(sid1).build();
        sr.save(s1);

        sidr.deleteById(1);       //当cascade = CascadeType.ALL时可以级联删除

    }


    //只有主键相同不算同一个对象所以自然不能删除
    //应该直接deleteById
    @Test
    public void name4() {
        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("其他信息").build();
        Student s1 = Student.builder().name("李文强").sid(sid1).build();
        sr.save(s1);

//        Student s2 = Student.builder().id(1).build();
//        sr.delete(s2);

        sr.deleteById(1);
    }


    @Test
    public void name3() {
        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("其他信息").build();
        Student s1 = Student.builder().name("李文强").sid(sid1).build();
        sr.save(s1);
        //级联删除
        //sr.delete(s1);

        //创建另一个属性完全相同的对象也可以级联删除
        Student s2 = Student.builder().id(1).name("李文强").sid(sid1).build();
        sr.delete(s2);
    }


    //s1中有sid即可维护外键关系,即使 用sidr也可以正常维护,但要保证sid中有s1,这样才能保证存sid的时候存s1,而s1维护了外键关系
    // 说明维护外键关系考得不是用谁的Repository而是对象本身是否定义与另一个对象的关系
    @Test
    public void name222() {
        Student s1 = Student.builder().name("李文强").build();
        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("其他信息").student(s1).build();
        s1.setSid(sid1);

        sidr.save(sid1);

    }
    //使用放弃维护外键的一方保存
    //sid中有s1所以s1也存入库,但是sid放弃维护关系,所以没有外键关系
    @Test
    public void name22() {
        Student s1 = Student.builder().name("李文强").build();
        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("其他信息").student(s1).build();
        sidr.save(sid1);

    }

    //使用维护外键的一方保存
    @Test
    public void name2() {
        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("其他信息").build();
        Student s1 = Student.builder().name("李文强").sid(sid1).build();
        sr.save(s1);
    }

}
