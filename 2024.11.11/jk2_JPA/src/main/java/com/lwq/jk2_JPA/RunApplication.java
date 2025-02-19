package com.lwq.jk2_JPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

//注解@EnableJpaAuditing，它是用来启动Jpa的审计功能，
//        比如说在使用建表中经常会加入 版本号、创建时间、修改时间 、创建者、修改者 这五个字段。
//        因此为了简化开发， 我们可以将其交给jpa来自动填充。
@EnableJpaAuditing
@SpringBootApplication
@EnableAsync
public class RunApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);

    }
}
