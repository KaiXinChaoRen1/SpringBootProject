package com.lwq.springboot_mybatis.service;

import java.util.List;

import com.lwq.springboot_mybatis.domain.User;

public interface UserService {

    List<User> findAll();

    User findByID(Integer id);

}
