package com.lwq.precious.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/test")
    public String name() {
        System.out.println("test执行了");
        return "我家大门常打开";
    }
    @GetMapping("/test2")
    public String name2() {
        System.out.println("test2执行了");
        return "我家大门常打开";
    }
}
