package com.lwq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.lwq.mapper"})  //通用mapper接口所在位置
public class LwqApplication {

    public static void main(String[] args) {
        SpringApplication.run(LwqApplication.class, args);
    }

}
