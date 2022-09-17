package com.lwq.springboot_mybatis.service.impl;


import com.lwq.springboot_mybatis.domain.User;
import com.lwq.springboot_mybatis.mapper.UserMapper;
import com.lwq.springboot_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> all = userMapper.findAll();
        return all;
    }

    @Override
    public User findByID(Integer id) {
        User u1 = userMapper.findByID(id);
        return u1;
    }
}
