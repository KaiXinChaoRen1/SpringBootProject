package com.lwq.springboot01.dao.inheritRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lwq.springboot01.Entity.inherit.Color;

public interface ColorRepository extends JpaRepository<Color,String>{
    
}
