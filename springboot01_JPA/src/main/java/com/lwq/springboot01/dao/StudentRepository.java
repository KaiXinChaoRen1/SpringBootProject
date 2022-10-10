package com.lwq.springboot01.dao;

import com.lwq.springboot01.Entity.HeadTeacher;
import com.lwq.springboot01.Entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Set;

public interface StudentRepository extends PagingAndSortingRepository<Student,Integer> {

    

    @Query
    List<Student> findByHt(HeadTeacher headTeacher);

    @Query
    Student findByName(String string);

}
