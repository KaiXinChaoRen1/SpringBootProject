package com.lwq.springboot01.dao;

import com.lwq.springboot01.Entity.HeadTeacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeadTeacherRepository extends JpaRepository<HeadTeacher,Integer> {
}
