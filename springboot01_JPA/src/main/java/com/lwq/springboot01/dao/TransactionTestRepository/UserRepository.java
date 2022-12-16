package com.lwq.springboot01.dao.TransactionTestRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lwq.springboot01.Entity.TransactionTestEntity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
