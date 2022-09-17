package com.lwq.springboot01.dao;

import com.lwq.springboot01.Entity.StudentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentIdRepository extends PagingAndSortingRepository<StudentId,Integer> {
}
