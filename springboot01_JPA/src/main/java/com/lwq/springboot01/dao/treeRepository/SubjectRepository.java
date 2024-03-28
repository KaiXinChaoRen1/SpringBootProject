package com.lwq.springboot01.dao.treeRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lwq.springboot01.entity.treeUtils.Subject;

public interface SubjectRepository extends JpaRepository<Subject,String> {
}
