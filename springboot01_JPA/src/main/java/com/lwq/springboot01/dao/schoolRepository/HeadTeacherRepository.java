package com.lwq.springboot01.dao.schoolRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lwq.springboot01.entity.schoolstory.HeadTeacher;

public interface HeadTeacherRepository extends JpaRepository<HeadTeacher,Integer> {
}
