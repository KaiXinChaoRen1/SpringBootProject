package com.lwq.springboot01.dao.schoolRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lwq.springboot01.Entity.schoolstory.StudentId;

public interface StudentIdRepository extends PagingAndSortingRepository<StudentId,Integer> {
}
