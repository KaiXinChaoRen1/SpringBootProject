package com.lwq.springboot01.dao.schoolRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lwq.springboot01.entity.schoolstory.HeadTeacher;
import com.lwq.springboot01.entity.schoolstory.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    

    @Query
    List<Student> findByHt(HeadTeacher headTeacher);

    @Query
    Student findByName(String string);

}
