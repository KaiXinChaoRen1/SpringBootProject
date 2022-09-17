package com.lwq.springboot03_mybatis_plus.service;


import com.lwq.springboot03_mybatis_plus.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(Integer id);
}
