package com.lwq.jk2_JPA.entity.yanTest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BDao extends JpaRepository<B, Integer> {

    // @Transactional(propagation = Propagation.REQUIRES_NEW)
    // @Override
    // <S extends B> S save(S entity);
}
