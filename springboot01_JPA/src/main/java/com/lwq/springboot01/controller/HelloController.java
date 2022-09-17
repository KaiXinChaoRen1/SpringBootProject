package com.lwq.springboot01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "我家大门常打开,开放怀抱等你";
    }

    @GetMapping("/hello1")
    public String hello1() {
        return "Spring Boot1111111111111111111111";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Spring Boot22222222222222222222222";
    }
}
