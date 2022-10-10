package com.lwq.springboot01;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.lwq.springboot01.Entity.Course;
import com.lwq.springboot01.Entity.Student;
import com.lwq.springboot01.dao.StudentRepository;

@SpringBootTest
public class ManyToMany {

    @Autowired
    StudentRepository sr;

    @Test
    public void clean() {
        System.out.println("yml修改为jpa:hibernate:ddl-auto: create 清空数据库,完事再改回来");
    }

    /**
     * 修改
     */
    @Transactional
    @Commit
    @Test
    public void name1() {
        Student s = sr.findByName("黄春");
        Course newCourse = Course.builder().name("电脑课").build();
        s.getCourseSet().add(newCourse);
        sr.save(s);
    }

    @Transactional
    @Commit
    @Test
    public void name() {
        Course course1 = Course.builder().name("语文").build();
        Course course2 = Course.builder().name("数学").build();
        Course course3 = Course.builder().name("英语").build();

        Set<Course> coursesHuang = new HashSet<>();
        coursesHuang.add(course1);
        coursesHuang.add(course2);

        Set<Course> coursesLong = new HashSet<>();
        coursesLong.add(course2);
        coursesLong.add(course3);

        Student studentHuang = Student.builder().name("黄春").courseSet(coursesHuang).build();
        Student studentLong = Student.builder().name("龙弟").courseSet(coursesLong).build();

        sr.save(studentHuang);
        sr.save(studentLong);
    }
}
