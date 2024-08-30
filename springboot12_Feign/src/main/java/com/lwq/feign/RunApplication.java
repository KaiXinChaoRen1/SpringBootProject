package com.lwq.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

/**
 * 复制一个项目
 * 修改包名,
 * 修改pom的artifactId
 * 修改import
 */
@SpringBootApplication
@Slf4j
@EnableFeignClients
public class RunApplication {

    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);

    }

}
