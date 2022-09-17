package com.lwq.config;

import com.lwq.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean   //将方法的返回值添加到容器中，id是方法名
    public User user() {
        return new User();
    }


}
