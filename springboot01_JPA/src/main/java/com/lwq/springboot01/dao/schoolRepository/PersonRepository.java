package com.lwq.springboot01.dao.schoolRepository;

import java.util.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lwq.springboot01.entity.schoolstory.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {
    @Query("Select p.name from Person as p where p.id=:id")
    String jpqlQuery(int id);

    //1
    //Person findByName(String name);
    //2
    Optional<Person> findByName(String name);



    // @Modifying
    // @Transactional
    // @Query(value = "INSERT INTO table_name (id, name) VALUES (:id, :name)", nativeQuery = true)
    // void insertMap(List<Map<String, Object>> dataList);

    // @Transactional
    // @Modifying
    // @Query(value = "INSERT INTO lwq_person (id,age) VALUES (:id,:age)"
    // + " ON DUPLICATE KEY UPDATE "
    // +" age=VALUES(age)", nativeQuery = true)
    // void upInsertPerson(List<Person> persons);
}
