package com.lwq.springboot11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableAsync
public class RunApplication {

    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);

    }

}
