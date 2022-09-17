package com.lwq.springboot05_condition.config;


import com.lwq.springboot05_condition.condtion.ClassCondition;
import com.lwq.springboot05_condition.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserConfig {

    @Bean
    //@Conditional(ClassCondition.class)  //自定义条件，根据这个实现了condition的类的返回值判断是否加载bean
    @ConditionalOnProperty(name = "lwq",havingValue = "666")  //spring提供的条件注解还有onclass，onbean等
    public User user(){
        return new User();

    }
}
