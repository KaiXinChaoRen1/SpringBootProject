package com.lwq.springboot01.dao.schoolRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lwq.springboot01.Entity.schoolstory.Person;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person,Integer>, JpaSpecificationExecutor<Person> {
    @Query("Select p.name from Person as p where p.id=:id")
    String jpqlQuery(int id);
}
