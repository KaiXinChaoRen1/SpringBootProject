package com.lwq.springboot01.service.TransactionTestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwq.springboot01.Entity.TransactionTestEntity.User;
import com.lwq.springboot01.dao.TransactionTestRepository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(){
        User newUser = User.builder().id(1L).name("黄春").build();
        //int i = 1 / 0;
        userRepository.save(newUser);
        int i = 1 / 0;
       
    }
}
