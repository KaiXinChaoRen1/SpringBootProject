package com.lwq.springboot01.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwq.springboot01.dao.schoolRepository.StudentIdRepository;
import com.lwq.springboot01.dao.schoolRepository.StudentRepository;
import com.lwq.springboot01.entity.schoolstory.Student;
import com.lwq.springboot01.entity.schoolstory.StudentId;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class One2OneService {
    @Autowired
    StudentRepository sr;

    @Autowired
    StudentIdRepository sidr;

    public void name3() {
        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("其他信息").build();
        Student s1 = Student.builder().name("李文强").sid(sid1).build();
        sr.save(s1);

        // 1.级联删除
        // sr.delete(s1);

        // 2.创建另一个属性完全相同的对象也可以级联删除
        // Student s2 = Student.builder().id(1).name("李文强").sid(sid1).build();
        // sr.delete(s2);

        // 3.主键相同不算同一个对象所以自然不能删除,甚至还会把s2保存进去?(抽空看一下sql)
        // Student s2 = Student.builder().id(1).build();
        // sr.delete(s2);

        // 4.直接根据主键删除不就好啦
        sr.deleteById(1);

        // 5.因为这个sid中没有设置student,所以与数据库中的不一样,所以不能删除
        // sidr.delete(sid1);

        // 6.删除数据库中查出来的就好了(只要设置了级联,被拥有的一方也一样能级联)
        // Optional<StudentId> findById = sidr.findById(1);
        // sidr.delete(findById.get());

        // 7.被拥有方根据id删除,如果不设级联,拥有方的外键值会删除吗?结果是表没有变化,不仅不会删除,连sid都不会删除,因为他被外键引用着
        // sidr.deleteById(1);

    }

    // s1中有sid就可以维护外键关系,即使用sidr(放弃维护一方的Repository)去保存也可以正常维护,
    // 但要保证sid中有s1,这样才能在存sid的时候存s1,而s1维护了外键关系
    // 说明维护外键关系靠得不是用谁的Repository,而是维护外键的对象本身是否定义了与另一个对象的关系
    public void save3() {
        Student s1 = Student.builder().name("lwq").build();
        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("hahah").student(s1).build();
        // 多一步就可以
        s1.setSid(sid1);

        sidr.save(sid1);
    }

    @Transactional
    public void save1() {

        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("hahhah").build();
        Student s1 = Student.builder().name("lwq").sid(sid1).build();
        sr.save(s1);

    }

    // 使用放弃维护外键的一方保存
    // sid中有s1所以s1也存入库,但是sid放弃维护关系,所以没有外键关系

    @Transactional
    public void save2() {
        Student s1 = Student.builder().name("lwq").build();
        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("hahhah").student(s1).build();

        sidr.save(sid1);

    }

    // 使用维护外键的一方保存
    public void addAndFind() {
        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("others").build();
        Student s1 = Student.builder().name("lwq").sid(sid1).build();
        System.out.println("保存前的s1的sid:" + s1.getSid());
        sr.save(s1);

        System.out.println("保存后的s1的sid:" + s1.getSid());// 保存后sid生成的id也会同步到内存里的java对象

        // 查询学生带着学号
        Optional<Student> stuOptional = sr.findById(1);
        Student student = stuOptional.get();
        System.out.println("学生是" + student.getName());
        System.out.println("学生对应的学号是" + student.getSid().getStudentIdNumber());

        // 查询学号带着学生
        Optional<StudentId> stuIdOptional = sidr.findById(1);
        StudentId studentId = stuIdOptional.get();
        System.out.println("学号是" + studentId.getStudentIdNumber());
        System.out.println("学号对应的学生是" + studentId.getStudent().getName());

    }

    public void addAndFind2() {
        save();
        // 查询学生带着学号
        Optional<Student> stuOptional = sr.findById(1);
        Student student = stuOptional.get();
        System.out.println("学生是" + student.getName());
        System.out.println("学生对应的学号是" + student.getSid().getStudentIdNumber());

        // 查询学号带着学生
        Optional<StudentId> stuIdOptional = sidr.findById(1);
        StudentId studentId = stuIdOptional.get();
        System.out.println("学号是" + studentId.getStudentIdNumber());
        System.out.println("学号对应的学生是" + studentId.getStudent().getName());

    }

    @Transactional
    public void addAndFind3() {
        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("others").build();
        Student s1 = Student.builder().name("lwq").sid(sid1).build();
        System.out.println("保存前的s1的sid:" + s1.getSid());
        sr.save(s1);

        System.out.println("保存后的s1的sid:" + s1.getSid());// 保存后sid生成的id也会同步到内存里的java对象

        // 查询学生带着学号
        Optional<Student> stuOptional = sr.findById(1);
        Student student = stuOptional.get();
        System.out.println("学生是" + student.getName());
        System.out.println("学生对应的学号是" + student.getSid().getStudentIdNumber());

        // 查询学号带着学生
        Optional<StudentId> stuIdOptional = sidr.findById(1);
        StudentId studentId = stuIdOptional.get();
        System.out.println("学号是" + studentId.getStudentIdNumber());
        System.out.println("学号对应的学生是" + studentId.getStudent().getName());

    }

    @Transactional
    void save() {
        StudentId sid1 = StudentId.builder().StudentIdNumber(202201).other("others").build();
        Student s1 = Student.builder().name("lwq").sid(sid1).build();
        System.out.println("保存前的s1的sid:" + s1.getSid());
        sr.save(s1);

        System.out.println("保存后的s1的sid:" + s1.getSid());// 保存后sid生成的id也会同步到内存里的java对象
    }

    public void find() {

        // 查询学生带着学号
        Optional<Student> stuOptional = sr.findById(1);
        Student student = stuOptional.get();
        System.out.println("学生是" + student.getName());
        System.out.println("学生对应的学号是" + student.getSid().getStudentIdNumber());

        // 查询学号带着学生
        Optional<StudentId> stuIdOptional = sidr.findById(1);
        StudentId studentId = stuIdOptional.get();
        System.out.println("学号是" + studentId.getStudentIdNumber());
        System.out.println("学号对应的学生是" + studentId.getStudent().getName());

    }

}
