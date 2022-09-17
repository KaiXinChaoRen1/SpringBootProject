package com.lwq.service.impl;

import com.github.pagehelper.PageHelper;
import com.lwq.domain.User;
import com.lwq.mapper.UserMapper;
import com.lwq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;  //idea提示，不影响运行


    public List<User> findAll() {
        List<User> users = userMapper.selectAll();
        return users;

    }

    public User findByID(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public void addUser(User user) {
       userMapper.insertSelective(user);
    }

    @Override
    public void updUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void delUser(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }
}
