package com.lwq.springboot01.dao.schoolRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lwq.springboot01.Entity.schoolstory.HeadTeacher;
import com.lwq.springboot01.Entity.schoolstory.Student;

import java.util.List;
import java.util.Set;

public interface StudentRepository extends PagingAndSortingRepository<Student,Integer> {

    

    @Query
    List<Student> findByHt(HeadTeacher headTeacher);

    @Query
    Student findByName(String string);

}
