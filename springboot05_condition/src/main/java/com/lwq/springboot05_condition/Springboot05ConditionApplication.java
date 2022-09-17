package com.lwq.springboot05_condition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * condition 选择性的创建bean
 */
@SpringBootApplication
public class Springboot05ConditionApplication {

    public static void main(String[] args) {
        //启动springboot应用，返回ioc容器
        ConfigurableApplicationContext context = SpringApplication.run(Springboot05ConditionApplication.class, args);

/*        //获取bean，redisTemplate
        Object redisTemplate = context.getBean("redisTemplate");
        //打印对象
        System.out.println(redisTemplate);*/

        Object user = context.getBean("user");
        System.out.println(user);



    }

}
