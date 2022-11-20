package com.lwq.springboot01.dao.treeRepository;

import com.lwq.springboot01.Entity.schoolstory.HeadTeacher;
import com.lwq.springboot01.Entity.tree.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,String> {
}
