package com.lwq.springboot03_mybatis_plus.service.impl;


import com.lwq.springboot03_mybatis_plus.entity.User;
import com.lwq.springboot03_mybatis_plus.mapper.UserMapper;
import com.lwq.springboot03_mybatis_plus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    @Override
    public User findById(Integer id) {
        User user = userMapper.selectById(id);
        return user;
    }
}
