package com.lwq.springboot_mybatis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lwq.springboot_mybatis.domain.User;
import com.lwq.springboot_mybatis.service.UserService;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testFindAll() {
        List<User> list =userService.findAll();
        System.out.println(list);
    }

    @Test
    public void testFindByID() {
        User user = userService.findByID(3);
        System.out.println(user);
    }


}
