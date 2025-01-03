package com.lwq.jk1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * 复制一个项目
 * 修改包名,
 * 修改pom的artifactId
 * 修改import
 * 修改Knife4jConfiguration配置中的controller位置
 */
@SpringBootApplication
@Slf4j
public class RunApplication {

    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);

    }

}
