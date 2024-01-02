package com.lwq.springboot01.dao.TransactionTestRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lwq.springboot01.entity.transactionTestEntity.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{
    
}
