package com.lwq.springboot01.dao;

import com.lwq.springboot01.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonRepository extends JpaRepository<Person,Integer>, JpaSpecificationExecutor {
}
