package com.lwq.slave2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * 复制一个项目
 * 修改包名,
 * 修改pom的artifactId
 * 修改import
 */
@SpringBootApplication
@Slf4j
public class AppSlave2Server {

    public static void main(String[] args) {
        SpringApplication.run(AppSlave2Server.class, args);
    }

}
