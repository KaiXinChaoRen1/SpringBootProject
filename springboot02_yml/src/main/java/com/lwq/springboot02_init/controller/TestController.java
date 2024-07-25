package com.lwq.springboot02_init.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestController {

    @RequestMapping("/")
    public String hehe1() {
        return "";
    }
}
