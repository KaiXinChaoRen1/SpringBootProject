package com.lwq.test;

import com.lwq.springboot_mybatis.SpringbootMybatisApplication;
import com.lwq.springboot_mybatis.domain.User;
import com.lwq.springboot_mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = SpringbootMybatisApplication.class)
        //不在同一包下需要加classes
class SpringbootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testFindAll() {
        List<User> list = userMapper.findAll();
        System.out.println(list);
    }

    @Test
    public void testFindByID() {
   /*     User user = userMapper.findByID(3);
        System.out.println(user);*/
        System.out.println(userMapper);
    }
/*        @Test
        public void testFindAll2() {
            List<User> list = userXmlMapper.findAll();
            System.out.println(list);
        }*/


}
