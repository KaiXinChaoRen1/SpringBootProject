package com.lwq.springboot_mybatis.controller;


import com.lwq.springboot_mybatis.domain.User;
import com.lwq.springboot_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("findAll")
    public List<User> hello() {
        List<User> all = userService.findAll();
        return all;
    }

    @GetMapping("{id}")
    public User hello(@PathVariable Integer id) {
        User u1 = userService.findByID(id);
        return u1;
    }
}
