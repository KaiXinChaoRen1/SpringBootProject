package com.lwq.springboot_mybatis.service;

import com.lwq.springboot_mybatis.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByID(Integer id);

}
