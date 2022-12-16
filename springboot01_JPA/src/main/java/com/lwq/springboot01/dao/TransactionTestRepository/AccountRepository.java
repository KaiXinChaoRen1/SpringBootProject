package com.lwq.springboot01.dao.TransactionTestRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lwq.springboot01.Entity.TransactionTestEntity.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{
    
}
