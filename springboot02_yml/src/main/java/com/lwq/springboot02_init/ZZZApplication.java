package com.lwq.springboot02_init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ZZZApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZZZApplication.class, args);
        System.out.println("应用服务启动完成~~~");
    }


}
