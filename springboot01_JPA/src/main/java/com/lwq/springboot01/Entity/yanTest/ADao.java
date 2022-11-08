package com.lwq.springboot01.Entity.yanTest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ADao extends JpaRepository<A,Integer> {

    //@Query
    A findByName(String name);

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Override
//    Optional<A> findById(Integer integer);
}
