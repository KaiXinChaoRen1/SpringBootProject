package com.lwq.springboot01.Entity.Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ADao extends JpaRepository<A,Integer> {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    Optional<A> findById(Integer integer);
}
