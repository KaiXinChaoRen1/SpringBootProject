package com.lwq.springboot02_init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ZZZApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ZZZApplication.class, args);
        System.out.println("应用服务启动完成~~~");
        System.out.println("直接获取容器中的bean-->Person:"+run.getBean("person"));
    }


}
