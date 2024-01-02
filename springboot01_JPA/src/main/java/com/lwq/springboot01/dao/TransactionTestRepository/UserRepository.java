package com.lwq.springboot01.dao.TransactionTestRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lwq.springboot01.entity.transactionTestEntity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
