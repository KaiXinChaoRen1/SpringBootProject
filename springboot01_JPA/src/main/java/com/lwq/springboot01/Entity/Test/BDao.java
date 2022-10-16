package com.lwq.springboot01.Entity.Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public interface BDao extends JpaRepository<B,Integer> {

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Override
//    <S extends B> S save(S entity);
}
