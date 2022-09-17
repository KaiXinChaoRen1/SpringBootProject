package com.lwq.springboot03_mybatis_plus;

import com.lwq.springboot03_mybatis_plus.entity.User;
import com.lwq.springboot03_mybatis_plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot03MybatisPlusApplicationTests {

    @Autowired
    private UserMapper um;
    @Test
    void test1() {
        List<User> users = um.selectList(null);
        System.out.println(users);

    }

}
